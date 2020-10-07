package com.thesamans.universityapplicationproject.model.users;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is used to authenticate users through spring security
 *
 * NOTE - The fields in this class are returned back to the front end when authenticated
 */
public class MyUserDetails implements UserDetails {

    private int userId;
    private String username;
    private String password;
    private String userType;
    private List<GrantedAuthority> authorities;
    private boolean hasApplied;

    public MyUserDetails() {

    }

    public MyUserDetails(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.userType = user.getClass().getTypeName();
        this.authorities = Arrays.stream(user.getRoles())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        if (user instanceof Student) {
            Student student = (Student) user;
            this.hasApplied = student.hasApplied();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserType() {
        return userType;
    }

    @Override
    public boolean isAccountNonExpired() {
        // hardcoded
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // hardcoded
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // hardcoded
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean hasApplied() {
        return hasApplied;
    }
}
