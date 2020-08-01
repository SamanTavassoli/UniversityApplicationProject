package com.thesamans.universityapplicationproject.model.objects;

import java.util.ArrayList;

public class CourseManager {

    private static ArrayList<Course> activeRegisteredCourses = new ArrayList<>();

    public static ArrayList<Course> getActiveRegisteredCourses() {
        return activeRegisteredCourses;
    }

    public static void setActiveRegisteredCourses(ArrayList<Course> activeRegisteredCourses) {
        CourseManager.activeRegisteredCourses = activeRegisteredCourses;
    }
}
