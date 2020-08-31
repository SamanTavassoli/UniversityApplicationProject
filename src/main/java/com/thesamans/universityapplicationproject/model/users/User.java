package com.thesamans.universityapplicationproject.model.users;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
/**
 * A User can log in the website and has access to further resources depending on it's type
 */
public class User {

    // Fields

    @Id
    @JsonProperty("userId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;

    // Get Set

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

}
