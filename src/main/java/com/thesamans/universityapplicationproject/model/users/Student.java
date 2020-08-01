package com.thesamans.universityapplicationproject.model.users;

import com.thesamans.universityapplicationproject.model.application.Application;

import java.util.ArrayList;
import java.util.Date;

public class Student extends User {

    /** Student Id given on sign up, separate from user id, used for applications */
    private int studentId;
    private Date dateOfBirth;
    private ArrayList<Application> applicationsSent;

    public ArrayList<Application> getApplicationsSent() {
        return applicationsSent;
    }

    public int getStudentId() {
        return studentId;
    }
}
