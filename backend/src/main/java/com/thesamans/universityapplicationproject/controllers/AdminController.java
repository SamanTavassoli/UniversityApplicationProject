package com.thesamans.universityapplicationproject.controllers;

import com.thesamans.universityapplicationproject.model.users.Admin;
import com.thesamans.universityapplicationproject.model.users.Student;
import com.thesamans.universityapplicationproject.model.users.User;
import com.thesamans.universityapplicationproject.model.users.UserType;
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

    @GetMapping
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @PostMapping(value = "/admin")
    public Admin createAdmit(@RequestBody Admin admin) {
        return registrationService.addUser(admin);
    }

    @GetMapping(value = "/mainAdmin")
    public Admin getAdmin() {
        return userService.getUser(UserType.ADMIN, 19);
    }

    @PostMapping(value = "/student")
    public Student addStudent(@RequestBody Student student) {
        return registrationService.addUser(student);
    }
}
