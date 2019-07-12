package com.gdgbbsr.spectra.services;

import com.gdgbbsr.spectra.dto.Error;
import com.gdgbbsr.spectra.dto.Result;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

public final class ResponseUtils {
    public static <T, M> Result<T> newConstraintViolationErrorResponse(Set<ConstraintViolation<M>> constraintViolations) {
        return new Result<>(constraintViolations.stream()
            .map(violation -> new Error(Error.Code.VALIDATION_ERROR,
                violation.getMessage(),
                violation.getPropertyPath().toString()))
            .collect(Collectors.toList()));
    }
}
