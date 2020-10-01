package com.thesamans.universityapplicationproject.model.users;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UniversityPublicInfo {
    @Id
    String username;
    int universityId;

    public UniversityPublicInfo(String username, int universityId) {
        this.username = username;
        this.universityId = universityId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }
}
