package com.thesamans.universityapplicationproject.model.users;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.thesamans.universityapplicationproject.model.course.Course;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class University extends User {

    @JsonProperty("universityId")
    private int universityId;
    /** Courses that the University has on offer */
    @JsonProperty("availableCourses")
    private ArrayList<Course> availableCourses = new ArrayList<>();



}
