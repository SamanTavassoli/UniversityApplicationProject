package com.thesamans.universityapplicationproject.controllers;

import com.thesamans.universityapplicationproject.dao.ApplicationDao;
import com.thesamans.universityapplicationproject.model.application.Application;
import com.thesamans.universityapplicationproject.model.course.Course;
import com.thesamans.universityapplicationproject.model.users.*;
import com.thesamans.universityapplicationproject.services.ApplicationService;
import com.thesamans.universityapplicationproject.services.CourseService;
import com.thesamans.universityapplicationproject.services.RegistrationService;
import com.thesamans.universityapplicationproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for admin users
 * Lots of access to most apis is given
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    ApplicationDao applicationDao;

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    ApplicationService applicationService;

    @GetMapping(value = "/users")
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @GetMapping(value = "/users/{userId}")
    public User getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @DeleteMapping(value = "/users/{userId}")
    public boolean deleteUser(@PathVariable int userId) {
        return userService.deleteUser(userId);
    }

    @GetMapping(value = "/mainAdmin")
    public Admin getMainAdmin() {
        return userService.getUser(UserType.ADMIN, 19);
    }

    @GetMapping(value = "/applications")
    public List<Application> getAllApplications() {
        return applicationDao.findAll();
    }

    @DeleteMapping(value = "/applications/{appId}")
    public boolean deleteApplication(@PathVariable int appId) {
        return applicationService.deleteApplication(appId);
    }

    @DeleteMapping(value = "/course/{courseId}")
    public boolean deleteCourse(@PathVariable int courseId) {
        return courseService.deleteCourse(courseId);
    }

    @PostMapping(value = "/admin")
    public Admin addAdmin(@RequestBody Admin admin) {
        return registrationService.addUser(admin);
    }

    @PostMapping(value = "/admin/base")
    public Admin addBaseAdmin() {
        return registrationService.addUser(
                new Admin("admin", "admin", "admin")
        );
    }

    @PostMapping(value = "/student")
    public Student addStudent(@RequestBody Student student) {
        return registrationService.addUser(student);
    }

    @PostMapping(value = "/uni")
    public University addUniversity(@RequestBody University university) {
        return registrationService.addUser(university);
    }
}
