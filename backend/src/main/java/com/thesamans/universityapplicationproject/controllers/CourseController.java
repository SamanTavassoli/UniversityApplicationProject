package com.thesamans.universityapplicationproject.controllers;

import com.thesamans.universityapplicationproject.model.course.Course;
import com.thesamans.universityapplicationproject.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/allCourses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

}
