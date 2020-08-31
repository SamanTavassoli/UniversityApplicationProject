package com.thesamans.universityapplicationproject.model.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thesamans.universityapplicationproject.model.application.Application;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Student extends User {

    /** Student Id given on sign up, separate from user id, used for applications */
    @JsonProperty("studentId")
    private int studentId;
    @JsonProperty("dob")
    private Date dateOfBirth;
    @JsonProperty("applicationsSent")
    private ArrayList<Application> applicationsSent;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ArrayList<Application> getApplicationsSent() {
        return applicationsSent;
    }

    public void setApplicationsSent(ArrayList<Application> applicationsSent) {
        this.applicationsSent = applicationsSent;
    }
}
