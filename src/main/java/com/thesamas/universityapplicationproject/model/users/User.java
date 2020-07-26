package com.thesamas.universityapplicationproject.model.users;

/**
 * A User can log in the website and has access to further resources depending on it's type
 */
public abstract class User {

    // Fields

    private int userId;
    private String username;
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
