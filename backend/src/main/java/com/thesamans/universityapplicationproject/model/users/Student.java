package com.thesamans.universityapplicationproject.model.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thesamans.universityapplicationproject.model.application.Application;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@Entity
public class Student extends User {

    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;
    @JsonProperty("applicationsSent")
    private ArrayList<Application> applicationsSent;

    public Student() {

    }

    public Student(String username, String password, String email, Date dateOfBirth) {
        Objects.requireNonNull(username, "must specify username");
        Objects.requireNonNull(password, "must specify password");
        Objects.requireNonNull(email, "must specify email");
        Objects.requireNonNull(dateOfBirth, "must specify dateOfBirth");

        // up to the user
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setDateOfBirth(dateOfBirth);

        // not up to user
        // not setting userId as it is auto generated
        this.setRoles(new String[] {"ROLE_STUDENT"});
        this.setApplicationsSent(new ArrayList<>());
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
