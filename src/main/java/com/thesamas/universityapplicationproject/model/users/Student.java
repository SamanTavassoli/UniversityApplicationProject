package com.thesamas.universityapplicationproject.model.users;

import com.thesamas.universityapplicationproject.model.Application.Application;

import java.util.ArrayList;
import java.util.Date;

public class Student extends User {

    private Date dateOfBirth;
    private ArrayList<Application> applicationsSent;
}
