package com.thesamans.universityapplicationproject.webapi.controllers;

import com.thesamans.universityapplicationproject.model.users.Student;
import com.thesamans.universityapplicationproject.model.users.University;
import com.thesamans.universityapplicationproject.model.users.User;
import com.thesamans.universityapplicationproject.services.users.StudentService;
import com.thesamans.universityapplicationproject.services.users.UniversityService;
import com.thesamans.universityapplicationproject.services.users.UserService;
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

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/student")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping(value = "/student/{userId}")
    public Student getStudent(@PathVariable int userId) {
        return studentService.getStudent(userId);
    }


    // universities

    @Autowired
    private UniversityService universityService;

    @PostMapping(value = "/uni")
    public University addUniversity(@RequestBody University university) {
        return universityService.addUniversity(university);
    }

    @PostMapping(value = "/uni/{userId}")
    public University getUniversity(@PathVariable int userId) {
        return universityService.getUniversity(userId);
    }
}
