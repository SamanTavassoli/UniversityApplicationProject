package com.thesamans.universityapplicationproject.model.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thesamans.universityapplicationproject.model.application.Application;

import javax.persistence.Entity;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Students are users that can apply to courses
 * They can view other courses, make/withdraw their applications, and monitor the progress on their application
 */
@Entity
public class Student extends User {

    private Date dateOfBirth;
    private ArrayList<Integer> coursesConsidered;
    private boolean hasApplied;


    public Student() {

    }

    public Student(String username, String password, String email, Date dateOfBirth, ArrayList<Integer> coursesConsidered) {
        Objects.requireNonNull(username, "must specify username");
        Objects.requireNonNull(password, "must specify password");
        Objects.requireNonNull(email, "must specify email");
        Objects.requireNonNull(dateOfBirth, "must specify dateOfBirth");

        // up to the user
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setDateOfBirth(dateOfBirth);
        this.setCoursesConsidered(coursesConsidered);

        // not up to user
        // not setting userId as it is auto generated
        this.setRoles(new String[] {"ROLE_STUDENT"});
        this.setHasApplied(false);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ArrayList<Integer> getCoursesConsidered() {
        return coursesConsidered;
    }

    public void setCoursesConsidered(ArrayList<Integer> coursesConsidered) {
        this.coursesConsidered = coursesConsidered;
    }

    public boolean hasApplied() {
        return hasApplied;
    }

    public void setHasApplied(boolean hasApplied) {
        this.hasApplied = hasApplied;
    }
}

