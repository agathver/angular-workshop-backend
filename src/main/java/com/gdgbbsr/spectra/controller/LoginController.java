package com.gdgbbsr.spectra.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET, path = "check_login")
    public Object checkLogin(Authentication authentication) {
        return authentication.getPrincipal();
    }
}
