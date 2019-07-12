package com.gdgbbsr.spectra.dto;

import lombok.Data;

@Data
public class Error {

    public enum Code {
        VALIDATION_ERROR,
        DUPLICATE_VALUE
    }

    private final Code code;
    private final String message;
    private final String field;
}
