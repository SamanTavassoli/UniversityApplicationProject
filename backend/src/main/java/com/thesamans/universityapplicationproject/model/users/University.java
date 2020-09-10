package com.thesamans.universityapplicationproject.model.users;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.thesamans.universityapplicationproject.model.course.Course;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@Entity
public class University extends User {

    /** Courses that the University has on offer */
    @JsonProperty("availableCourses")
    private ArrayList<Course> availableCourses = new ArrayList<>();

    public University(String username, String password, String email) {
        Objects.requireNonNull(username, "must specify username");
        Objects.requireNonNull(password, "must specify password");
        Objects.requireNonNull(email, "must specify email");

        // up to the user
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);

        // not up to user
        // not setting userId as it is auto generated
        this.setRoles(new String[] {"ROLE_UNIVERSITY"});
        this.setAvailableCourses(new ArrayList<>());
    }

    public ArrayList<Course> getAvailableCourses() {
        return availableCourses;
    }

    public void setAvailableCourses(ArrayList<Course> availableCourses) {
        this.availableCourses = availableCourses;
    }
}
