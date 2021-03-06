package com.thesamans.universityapplicationproject.model.users;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.thesamans.universityapplicationproject.model.course.Course;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Universities can create courses, to which students apply
 * They are responsible for managing applications to their different courses
 * They have access to the tools they need to manage their applications in their profile
 */
@Entity
public class University extends User {

    public University() {
    }

    public University(String username, String password, String email) {
        Objects.requireNonNull(username, "must specify username");
        Objects.requireNonNull(password, "must specify password");
        Objects.requireNonNull(email, "must specify email");

        // up to the user
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);

        // not up to user
        // not setting userId as it is auto generated
        this.setRoles(new String[] {"ROLE_UNIVERSITY"});
    }
}
