package com.gdgbbsr.spectra.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RegistrationRequest {
    @Pattern(regexp = "[\\w_]+")
    private String username;

    @Email
    private String email;

    @NotBlank
    private String password;
}
