package com.thesamans.universityapplicationproject.controllers;

import com.thesamans.universityapplicationproject.model.course.Course;
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

    @GetMapping(value = "/student/getConsideredCourses/{userId}")
    public List<Integer> getConsideredCourses(@PathVariable int userId) {
        return userService.getConsideredCourses(userId);
    }

    @PostMapping(value = "/student/addToConsideredCourses/{courseId}/{userId}")
    public boolean addToConsideredCourses(@PathVariable int courseId, @PathVariable int userId) {
        return userService.addToConsideredCourses(courseId, userId);
    }

    @PostMapping(value = "/student/removeFromConsideredCourses/{courseId}/{userId}")
    public boolean removeFromConsideredCourses(@PathVariable int courseId, @PathVariable int userId) {
        return userService.removeFromConsideredCourses(courseId, userId);
    }

    @GetMapping(value = "/student/isConsideredCourse/{courseId}/{userId}")
    public boolean isConsideredCourse(@PathVariable int courseId, @PathVariable int userId) {
        return userService.isConsideredCourse(courseId, userId);
    }

    // universities

    @GetMapping(value = "/university/{universityId}")
    public University getUniversity(@PathVariable int universityId) {
        return userService.getUser(UserType.UNIVERSITY, universityId);
    }

}
