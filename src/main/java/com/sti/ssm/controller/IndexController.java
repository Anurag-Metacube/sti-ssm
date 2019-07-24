package com.sti.ssm.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sti.ssm.annotation.SAMLUser;
import com.sti.ssm.config.security.SAMLUserDetails;

@Controller
public class IndexController extends BaseController {


	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	
	  @RequestMapping("/home") 
	  public ModelAndView home(Principal principal) {
		  ModelAndView homeView = new ModelAndView("home");
	  homeView.addObject("userId", principal.getName());
	  String userDetails = "not initialized";
	  if (principal instanceof KeycloakAuthenticationToken) {
		  KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) principal; 
	        KeycloakPrincipal keyPrincipal=(KeycloakPrincipal)token.getPrincipal();
	        KeycloakSecurityContext session = keyPrincipal.getKeycloakSecurityContext();
	        AccessToken accessToken = session.getToken();
  		userDetails = " UserName : " +accessToken.getPreferredUsername() + accessToken.getOtherClaims();
  		}
	  homeView.addObject("userAttributes", userDetails); 
	  homeView.addObject("samlAttributes", null); 
	  return homeView;
	  }
	  
	  @GetMapping("/logout")
	  public String logout(HttpServletRequest request) throws Exception {
	      request.logout();
	      return "redirect:/";
	  }
	 
	
}
