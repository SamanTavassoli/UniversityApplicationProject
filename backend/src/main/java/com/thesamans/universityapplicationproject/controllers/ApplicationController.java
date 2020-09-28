package com.thesamans.universityapplicationproject.controllers;

import com.thesamans.universityapplicationproject.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/application")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @PostMapping(value = "/sendApplications/{userId}")
    public boolean sendApplications(@PathVariable int userId, @RequestBody int[] courseIds) {
        return applicationService.sendApplications(userId, courseIds);
    }

}
