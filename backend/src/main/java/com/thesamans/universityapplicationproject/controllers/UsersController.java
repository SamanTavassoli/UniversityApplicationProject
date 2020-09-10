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


    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }

    // students

    @GetMapping(value = "/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return userService.getUser(UserType.STUDENT, studentId);
    }

    // universities


}
