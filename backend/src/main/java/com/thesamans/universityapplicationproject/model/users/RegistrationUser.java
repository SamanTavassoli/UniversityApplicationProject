package com.thesamans.universityapplicationproject.model.users;

import java.util.Date;

/**
 * This class determines the information that a user must provide when doing the registration
 */
public class RegistrationUser {

    private String username;
    private String password;
    private String email;
    private String userType;
    private String dateOfBirth; // only for students

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
