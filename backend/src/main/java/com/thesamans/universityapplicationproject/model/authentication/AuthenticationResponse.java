package com.thesamans.universityapplicationproject.model.authentication;

/**
 * Corresponds to LoggedInUser on front end
 */
public class AuthenticationResponse {

    private final String username;
    private final String userType;
    private final String token;


    public AuthenticationResponse(String username, String userType, String jwt) {
        this.username = username;
        this.userType = userType;
        this.token = jwt;
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
}
