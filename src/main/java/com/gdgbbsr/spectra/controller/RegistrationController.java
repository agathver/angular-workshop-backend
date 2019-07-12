package com.gdgbbsr.spectra.controller;

import com.gdgbbsr.spectra.dto.Error;
import com.gdgbbsr.spectra.dto.RegistrationRequest;
import com.gdgbbsr.spectra.dto.Result;
import com.gdgbbsr.spectra.models.User;
import com.gdgbbsr.spectra.services.UserService;
import com.gdgbbsr.spectra.services.UsernameNotAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static com.gdgbbsr.spectra.services.ResponseUtils.newConstraintViolationErrorResponse;

@RestController
@RequestMapping("/auth/")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private Validator validator;

    @PostMapping("register")
    public ResponseEntity<Result<User>> register(@RequestBody RegistrationRequest registrationRequest) {

        Set<ConstraintViolation<RegistrationRequest>> constraintViolations = validator.validate(registrationRequest);
        if (!constraintViolations.isEmpty()) {
            return new ResponseEntity<>(newConstraintViolationErrorResponse(constraintViolations),
                HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            User user = this.userService.register(registrationRequest.getUsername(), registrationRequest.getPassword());
            return new ResponseEntity<>(new Result<>(user), HttpStatus.OK);
        } catch (UsernameNotAvailableException ex) {
            return new ResponseEntity<>(new Result<>(new Error(Error.Code.DUPLICATE_VALUE,
                ex.getMessage(),
                "username")), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


}
