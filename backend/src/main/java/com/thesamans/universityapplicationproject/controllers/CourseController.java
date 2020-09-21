package com.thesamans.universityapplicationproject.controllers;

import com.thesamans.universityapplicationproject.model.course.Course;
import com.thesamans.universityapplicationproject.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public boolean addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

}
