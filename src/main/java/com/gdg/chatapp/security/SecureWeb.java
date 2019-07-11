package com.gdg.chatapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(100)
@Configuration
@EnableWebSecurity
public class SecureWeb extends WebSecurityConfigurerAdapter{

	@Autowired
	private  AccountAuthenticationProvider userAuthenticationProvider;

	@Autowired
	private void configureGlobal(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(userAuthenticationProvider);
	}
	
	protected void configure(HttpSecurity http) throws Exception {

		http
			.authorizeRequests().antMatchers("/api/register/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin().and()
			.httpBasic();
	}
}
