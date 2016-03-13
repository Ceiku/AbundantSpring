package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@SpringBootApplication
@EnableOAuth2Sso
public class RoleHierarchyOauth2Application extends WebSecurityConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(RoleHierarchyOauth2Application.class, args);
	}
}
