package com.thesamans.universityapplicationproject.model.requests_responses;

/**
 * Contains username for a student when requested with studentId
 */
public class UsernameForStudentResponse {

    private final String username;

    public UsernameForStudentResponse(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
}
