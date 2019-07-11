package com.gdg.chatapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class AccountAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private UserDetailsService userService;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

		//We need to secure password, using some hashing mechanism.
		// Currently we are storing password as plain text in memory.
		if (!authentication.getCredentials().toString().contentEquals(userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid Username or Password !!");
		}
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		return this.userService.loadUserByUsername(username);
	}

}
