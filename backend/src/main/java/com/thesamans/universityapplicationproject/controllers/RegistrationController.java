package com.thesamans.universityapplicationproject.controllers;

import com.thesamans.universityapplicationproject.model.users.RegistrationUser;
import com.thesamans.universityapplicationproject.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/register")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping
    public boolean register(@RequestBody RegistrationUser user) {
        return registrationService.registerUser(user);
    }
}
