package com.thesamans.universityapplicationproject.model.users;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

// @Table(name = "whatever table name I want to use in the future") // default is just User for this class
@Entity
/**
 * A User can log in the website and has access to further resources depending on it's type
 * This is a base class that shouldn't be instantiated unless for testing
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
    @JsonProperty("email")
    private String email;
    /**
     * Authorities
     * Normally would be in a separate place but here for now
     */
    @JsonProperty("roles")
    private String[] roles;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
