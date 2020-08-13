package com.thesamans.universityapplicationproject.controllers;

import com.thesamans.universityapplicationproject.model.users.Student;
import com.thesamans.universityapplicationproject.model.users.University;
import com.thesamans.universityapplicationproject.model.users.User;
import com.thesamans.universityapplicationproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @GetMapping(value = "/{userId}")
    public User getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }

    // students

    @PostMapping(value = "/student")
    public Student addStudent(@RequestBody Student student) {
        return userService.addUser(student);
    }

    @GetMapping(value = "/student/{userId}")
    public Student getStudent(@PathVariable int userId) {
        return userService.getUser(userId);
    }


    // universities

    @PostMapping(value = "/uni")
    public University addUniversity(@RequestBody University university) {
        return userService.addUser(university);
    }

    @PostMapping(value = "/uni/{userId}")
    public University getUniversity(@PathVariable int userId) {
        return userService.getUser(userId);
    }
}