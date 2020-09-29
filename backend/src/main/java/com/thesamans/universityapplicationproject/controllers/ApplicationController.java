package com.thesamans.universityapplicationproject.controllers;

import com.thesamans.universityapplicationproject.model.application.Application;
import com.thesamans.universityapplicationproject.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/application")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @PostMapping(value = "/student/sendApplications/{userId}")
    public boolean sendApplications(@PathVariable int userId, @RequestBody int[] courseIds) {
        return applicationService.sendApplications(userId, courseIds);
    }

    @GetMapping(value = "/uni/getApplicationsForCourse/{courseId}")
    public List<Application> getApplicationsForCourse(@PathVariable int courseId) {
        return applicationService.getApplicationsForCourse(courseId);
    }

    @GetMapping(value = "/uni/getApplicationForId/{applicationId}")
    public Application getApplicationForId(@PathVariable int applicationId) {
        return applicationService.getApplicationForId(applicationId);
    }

    @GetMapping(value = "/uni/setApplicationToInReview/{applicationId}")
    public boolean setApplicationToInReview(@PathVariable int applicationId) {
        return applicationService.setApplicationToInReview(applicationId);
    }

}
