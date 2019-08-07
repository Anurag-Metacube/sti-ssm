package com.sti.ssm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableCaching
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages = {"com.smartsti.auth.jwt.client.rest"})
@ComponentScan(basePackages = {"com.smartsti.auth.jwt.client.hash"})
@ComponentScan(basePackages = {"com.smartsti.auth.jwt.client.model"})
public class StiSsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(StiSsmApplication.class, args);
	}

}

