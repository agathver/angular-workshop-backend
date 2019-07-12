package com.gdg.chatapp.security;

public class AccountAlreadyExistsException extends RuntimeException {


    /**
     *
     */
    private static final long serialVersionUID = 7522426337230801325L;

    public AccountAlreadyExistsException(String string) {
        super(string);
    }

}
