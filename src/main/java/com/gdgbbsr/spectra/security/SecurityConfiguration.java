package com.gdgbbsr.spectra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Order(100)
@Configuration
@EnableWebSecurity
@CrossOrigin
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private SpectraAuthenticationProvider userAuthenticationProvider;

    @Autowired
    private void configureGlobal(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(userAuthenticationProvider);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }
}
