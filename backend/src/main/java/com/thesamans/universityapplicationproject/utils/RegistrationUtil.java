package com.thesamans.universityapplicationproject.utils;

import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.application.Application;
import com.thesamans.universityapplicationproject.model.course.Course;
import com.thesamans.universityapplicationproject.model.users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@Service
public class RegistrationUtil {

    @Autowired
    UserDao userDao;

    // main functions

    /**
     * Performs checks for users other that admin users
     * @param user user to check
     * @return true if user details are allowed
     */
    public boolean canCreateUser(RegistrationUser user) {

        // checks for all users
        boolean userCheck =
                validateUsername(user.getUsername())
                && validatePassword(user.getPassword())
                && validateEmail(user.getEmail())
                && !(userDao.existsByUsername(user.getUsername()));

        UserType userType = parseUserType(user.getUserType());

        if (userType.equals(UserType.STUDENT)) {
            boolean studentCheck = validateDateOfBirth(parseDateOfBirth(user.getDateOfBirth()));
            return userCheck && studentCheck;
        } else if (userType.equals(UserType.UNIVERSITY)) {
            boolean universityCheck = true; // TODO: implement checks
            return userCheck && universityCheck;
        } else {
            return false; // cannot create other kinds of users
        }
    }

    /**
     * Creates a student or a university user
     * Saves the user to the userDao
     * Admins should not be created using this function
     * @param user user template to user to create user
     */
    public void createUser(RegistrationUser user) {
        UserType userType = parseUserType(user.getUserType());
        if (userType.equals(UserType.STUDENT)) {
            userDao.save(new Student(
                    user.getUsername(),
                    user.getPassword(),
                    user.getEmail(),
                    parseDateOfBirth(user.getDateOfBirth()),
                    new ArrayList<>()));
        } else if (userType.equals(UserType.UNIVERSITY)) {
            userDao.save(new University(
                    user.getUsername(),
                    user.getPassword(),
                    user.getEmail()));
        } else {
            throw new IllegalArgumentException("UserType must either be STUDENT or UNIVERSITY");
        }
    }

    // helper functions

    private boolean validatePassword(String password) {
        return true; // TODO: implement
    }

    private boolean validateUsername(String username) {
        return true; // TODO: implement
    }

    private boolean validateEmail(String email) {
        if (!email.contains("@")) {
            return false;
        }
        return true; // TODO: implement
    }

    private boolean validateDateOfBirth(Date dateOfBirth) {
        return true; // TODO: implement
    }

    private Date parseDateOfBirth(String dateOfBirthString) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirthString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Date of birth must be of format dd/MM/yyyy");
        }
    }

    private UserType parseUserType(String userType) {
        return UserType.valueOf(userType.toUpperCase());
    }
}
