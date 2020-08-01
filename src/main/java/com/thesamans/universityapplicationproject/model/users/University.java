package com.thesamans.universityapplicationproject.model.users;


import com.thesamans.universityapplicationproject.model.objects.Course;

import java.util.ArrayList;

public class University extends User {

    private int universityId;
    /** Courses that the University has on offer */
    private ArrayList<Course> availableCourses = new ArrayList<>();



}
