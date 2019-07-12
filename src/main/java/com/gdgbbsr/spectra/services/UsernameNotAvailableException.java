package com.gdgbbsr.spectra.services;

public class UsernameNotAvailableException extends Exception {
    public UsernameNotAvailableException() {
        super("Username not available");
    }
}
