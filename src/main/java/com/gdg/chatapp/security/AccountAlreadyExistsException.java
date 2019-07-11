package com.gdg.chatapp.security;

public class AccountAlreadyExistsException extends RuntimeException {
	
	
	public AccountAlreadyExistsException(String string) {
		super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522426337230801325L;

}
