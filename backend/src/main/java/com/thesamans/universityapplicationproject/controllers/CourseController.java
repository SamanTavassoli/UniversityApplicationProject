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

    @PostMapping("/add")
    public boolean addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @DeleteMapping("/delete/{courseId}")
    public boolean deleteCourse(@PathVariable int courseId) {
        return courseService.deleteCourse(courseId);
    }

    @GetMapping("/public/singleCourse/{courseId}")
    public Course getCourse(@PathVariable int courseId) {
        return courseService.getCourse(courseId);
    }

    @GetMapping("/public/allCourses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/public/allCoursesForUni/{universityId}")
    public List<Course> getAllCoursesForUni(@PathVariable int universityId) {
        return courseService.getAllCoursesForUni(universityId);
    }

}
