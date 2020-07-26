package com.thesamas.universityapplicationproject.model.objects;

import com.thesamas.universityapplicationproject.model.Application.Application;
import com.thesamas.universityapplicationproject.model.users.University;

import java.util.ArrayList;

public class Course {

    private University fromUniversity;
    private String courseName;
    private int courseId;

    /** Maximum number of students that the course can take */
    private int availableSlots;
    /** Number of years the course will take to complete */
    private int courseDuration;
    /** Yearly fees for this course */
    private int fees;

    private ArrayList<Application> applicationsReceived;

}
