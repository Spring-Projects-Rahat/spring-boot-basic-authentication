package com.example.ba.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SampleConfig extends WebSecurityConfigurerAdapter{

	private static final String USER = "USER";
	private static final String ADMIN = "ADMIN";
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
		.antMatchers("/greeting/customer/*").hasRole(USER)
		.antMatchers("greeting/customer/private/*").hasRole(ADMIN)
	.and()
		.formLogin();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.inMemoryAuthentication()
		 .withUser("Sankalp").password("password").roles(USER, ADMIN)
		 .and()
		 .withUser("Rahat").password("password").roles(USER);
		 
	}
	
}
