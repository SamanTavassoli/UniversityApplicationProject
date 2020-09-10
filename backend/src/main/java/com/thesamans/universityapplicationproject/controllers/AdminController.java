package com.thesamans.universityapplicationproject.controllers;

import com.thesamans.universityapplicationproject.model.users.*;
import com.thesamans.universityapplicationproject.services.RegistrationService;
import com.thesamans.universityapplicationproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    RegistrationService registrationService;

    @GetMapping(value = "/users")
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @GetMapping(value = "/mainAdmin")
    public Admin getMainAdmin() {
        return userService.getUser(UserType.ADMIN, 19);
    }

    @PostMapping(value = "/admin")
    public Admin addAdmin(@RequestBody Admin admin) {
        return registrationService.addUser(admin);
    }

    @PostMapping(value = "/student")
    public Student addStudent(@RequestBody Student student) {
        return registrationService.addUser(student);
    }

    @PostMapping(value = "/uni")
    public University addUniversity(@RequestBody University university) {
        return registrationService.addUser(university);
    }
}
