package com.sti.ssm.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.filter.KeycloakPreAuthActionsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;

import com.smartsti.auth.jwt.client.HttpConfig;
import com.smartsti.auth.jwt.client.JwtConfig;
import com.smartsti.auth.jwt.client.rest.AssistKeycloakAuthenticationProcessingFilter;
import com.smartsti.auth.jwt.client.rest.AssistKeycloakPreAuthActionsFilter;
import com.smartsti.auth.jwt.client.rest.JwtTokenAuthenticationProvider;
import com.smartsti.auth.jwt.client.rest.JwtTokenAuthenticationV1Filter;

/**
 * Created by brennan.mackay on 2017-04-07.
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

	@Autowired
	private JwtTokenAuthenticationProvider authenticationProvider;


	@Bean
	public GrantedAuthoritiesMapper grantedAuthoritiesMapper() {
		SimpleAuthorityMapper mapper = new SimpleAuthorityMapper();
		mapper.setConvertToUpperCase(true);
		return mapper;
	}

	@Override
	protected KeycloakAuthenticationProvider keycloakAuthenticationProvider() {
		final KeycloakAuthenticationProvider provider = super.keycloakAuthenticationProvider();
		provider.setGrantedAuthoritiesMapper(grantedAuthoritiesMapper());
		return provider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider);
		auth.authenticationProvider(keycloakAuthenticationProvider());
	}

	@Bean
	public JwtConfig getJwtConfig() {
		return new JwtConfig();
	}

	@Bean
	public HttpConfig getHttpConfig() {
		return new HttpConfig();
	}

	@Bean
	@Override
	protected AssistKeycloakAuthenticationProcessingFilter keycloakAuthenticationProcessingFilter() throws Exception {
		AssistKeycloakAuthenticationProcessingFilter filter = new AssistKeycloakAuthenticationProcessingFilter(
				authenticationManagerBean());
		filter.setSessionAuthenticationStrategy(sessionAuthenticationStrategy());
		return filter;
	}

	@Bean
	@Override
	protected KeycloakPreAuthActionsFilter keycloakPreAuthActionsFilter() {
		return new AssistKeycloakPreAuthActionsFilter(httpSessionManager());
	}

	@Bean
	public KeycloakConfigResolver keycloakConfigResolver() {
		return new KeycloakSpringBootConfigResolver();
	}

	@Override
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		return new NullAuthenticatedSessionStrategy();
	}

    @Autowired
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    /**
     * Factory for TokenAuthenticationFilter
     */
    @Bean
    public JwtTokenAuthenticationV1Filter tokenAuthenticationFilter() {
        return new JwtTokenAuthenticationV1Filter();
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
    	http
    	.csrf().disable()
            .exceptionHandling()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.NEVER)
            .and()
            .addFilterAfter(tokenAuthenticationFilter(), SecurityContextPersistenceFilter.class)
            .addFilterAfter(keycloakAuthenticationProcessingFilter(), JwtTokenAuthenticationV1Filter.class)
            .addFilterAfter(keycloakAuthenticatedActionsRequestFilter(), AssistKeycloakAuthenticationProcessingFilter.class)
            .addFilterAfter(keycloakSecurityContextRequestFilter(), SecurityContextHolderAwareRequestFilter.class)
            .authorizeRequests()
            .requestMatchers(EndpointRequest.to("health", "info"))
            .permitAll()
            .requestMatchers(new OrRequestMatcher(
                new AntPathRequestMatcher("/enrollments/new_requests", HttpMethod.POST.name()),
                new AntPathRequestMatcher("/enrollments/new_requests/*/process", HttpMethod.POST.name()),
                new AntPathRequestMatcher("/enrollments/*", HttpMethod.GET.name())
            ))
            .permitAll()
            .requestMatchers(new AndRequestMatcher(
                new RequestHeaderRequestMatcher("Access-Control-Allow-Headers", "open"),
                new OrRequestMatcher(
                    new AntPathRequestMatcher("/card/*/enrollment", HttpMethod.POST.name()))
            ))
            .permitAll()
            .antMatchers( //resources require for documentation and home pages
            	"/",
            	"/index",
                "/v2/api-docs",
                "/swagger-ui*",
                "/webjars/**/*",
                "/swagger-resources",
                "/swagger-resources/**/*",
                "/card/fulfillment",
                "/card/fulfillment/ecard"
            )
            .permitAll()
            .antMatchers("/**").fullyAuthenticated();
	}
}
