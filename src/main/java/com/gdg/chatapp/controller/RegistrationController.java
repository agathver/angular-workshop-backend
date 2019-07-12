package com.gdg.chatapp.controller;

import com.gdg.chatapp.models.RegisterModel;
import com.gdg.chatapp.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterModel details) {
        userService.registerUser(details.getName(), details.getPhone(), details.getPassword());
        return new ResponseEntity<String>("Successfully Registered", HttpStatus.OK);
    }


}
