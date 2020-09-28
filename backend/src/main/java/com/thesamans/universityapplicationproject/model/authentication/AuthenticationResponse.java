package com.thesamans.universityapplicationproject.model.authentication;

/**
 * Corresponds to LoggedInUser on front end
 */
public class AuthenticationResponse {

    private final int userId;
    private final String username;
    private final String userType;
    private final String token;
    private final boolean hasApplied;


    public AuthenticationResponse(int userId, String username, String userType, String jwt, boolean hasApplied) {
        this.userId = userId;
        this.username = username;
        this.userType = userType;
        this.token = jwt;
        this.hasApplied = hasApplied;
    }

    public int getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getUserType() {
        return userType;
    }

    public boolean hasApplied() {
        return hasApplied;
    }
}
