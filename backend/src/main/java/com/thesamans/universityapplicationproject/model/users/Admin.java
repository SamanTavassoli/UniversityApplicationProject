package com.thesamans.universityapplicationproject.model.users;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

    public Admin() {

    }

    public Admin(String username, String password, String email) {
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setRoles(new String[] {"ROLE_ADMIN"});
    }

}
