package com.thesamans.universityapplicationproject.controllers;

import com.thesamans.universityapplicationproject.model.users.*;
import com.thesamans.universityapplicationproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Manages requests for user information
 */
@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

    @Autowired
    private UserService userService;

    // test

    @GetMapping(value = "/student/test")
    public String testStudent() {
        return "test student success";
    }

    @GetMapping(value = "/university/test")
    public String testUniversity() {
        return "test uni success";
    }

    // students

    @GetMapping(value = "/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return userService.getUser(UserType.STUDENT, studentId);
    }

    // universities

    @GetMapping(value = "/university/{universityId}")
    public University getUniversity(@PathVariable int universityID) {
        return userService.getUser(UserType.UNIVERSITY, universityID);
    }

}
