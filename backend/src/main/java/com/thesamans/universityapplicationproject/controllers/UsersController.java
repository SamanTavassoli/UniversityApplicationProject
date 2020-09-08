package com.thesamans.universityapplicationproject.controllers;

import com.thesamans.universityapplicationproject.model.authentication.AuthenticationRequest;
import com.thesamans.universityapplicationproject.model.authentication.AuthenticationResponse;
import com.thesamans.universityapplicationproject.model.users.*;
import com.thesamans.universityapplicationproject.utils.JwtUtil;
import com.thesamans.universityapplicationproject.services.MyUserDetailsService;
import com.thesamans.universityapplicationproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }

    // admin

    @PostMapping(value = "/admin/admin")
    public Admin createAdmit(@RequestBody Admin admin) {
        return userService.addUser(admin);
    }

    @GetMapping(value = "/admin/mainAdmin")
    public Admin getAdmin() {
        return userService.getUser(UserType.ADMIN, 19);
    }

    @PostMapping(value = "/admin/student")
    public Student addStudent(@RequestBody Student student) {
        return userService.addUser(student);
    }

    // students

    @PostMapping(value = "/student")
    public Boolean registerStudent(@RequestBody Student student) {
        return userService.registerUser(student);
    }

    @GetMapping(value = "/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return userService.getUser(UserType.STUDENT, studentId);
    }

    // universities
}
