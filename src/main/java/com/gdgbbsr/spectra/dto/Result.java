package com.gdgbbsr.spectra.dto;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class Result<T> {
    private final boolean success;
    private final List<Error> errors;
    private final T data;

    public Result(T data) {
        this.success = true;
        this.errors = Collections.emptyList();
        this.data = data;
    }

    public Result(List<Error> errors) {
        this.success = false;
        this.errors = errors;
        this.data = null;
    }

    public Result(Error error) {
        this.success = false;
        this.errors = Collections.singletonList(error);
        this.data = null;
    }

    public boolean isSuccess() {
        return success;
    }
}
