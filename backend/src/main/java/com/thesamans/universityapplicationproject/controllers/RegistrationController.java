package com.thesamans.universityapplicationproject.controllers;

import com.thesamans.universityapplicationproject.model.users.Student;
import com.thesamans.universityapplicationproject.model.users.University;
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

    @PostMapping(value = "/student")
    public boolean register(@RequestBody Student student) {
        return registrationService.registerUser(student);
    }

    @PostMapping(value = "/university")
    public boolean register(@RequestBody University university) {
        return registrationService.registerUser(university);
    }
}
