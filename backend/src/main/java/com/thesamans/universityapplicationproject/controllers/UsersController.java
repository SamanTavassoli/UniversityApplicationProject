package com.thesamans.universityapplicationproject.controllers;

import com.thesamans.universityapplicationproject.model.users.*;
import com.thesamans.universityapplicationproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Manages requests for user information
 */
@RestController
@RequestMapping(value = "/user")
public class UsersController {

    @Autowired
    private UserService userService;

    // test

    /** Returning an array because the json gets messed up if I just send a string */
    @GetMapping(value = "/student/test")
    public ResponseEntity<String[]> testStudent() {
        return ResponseEntity.ok(new String[] {"test student success"});
    }

    @GetMapping(value = "/university/test")
    public ResponseEntity<String[]> testUniversity() {
        return ResponseEntity.ok(new String[] {"test uni success"});
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
