package com.thesamans.universityapplicationproject.controllers;

import com.thesamans.universityapplicationproject.model.authentication.AuthenticationRequest;
import com.thesamans.universityapplicationproject.model.authentication.AuthenticationResponse;
import com.thesamans.universityapplicationproject.model.users.Student;
import com.thesamans.universityapplicationproject.model.users.University;
import com.thesamans.universityapplicationproject.model.users.User;
import com.thesamans.universityapplicationproject.services.StudentService;
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

    @Autowired
    private StudentService studentService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @GetMapping
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @GetMapping(value = "/{userId}")
    public User getUser(@PathVariable int userId) {
        return userService.getUser(new User(), userId);
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }

    // students

    /**
     * Tries to register a student to the database
     * @param student student to be registered
     * @return true if student could be added
     */
    @PostMapping(value = "/student")
    public Boolean registerStudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    @GetMapping(value = "/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return studentService.getStudent(studentId);
    }

    /** For Admins to easily add students */
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }


    // universities

    @PostMapping(value = "/uni")
    public University addUniversity(@RequestBody University university) {
        return userService.addUser(university);
    }

    @GetMapping(value = "/uni/{userId}")
    public University getUniversity(@PathVariable int userId) {
        return userService.getUser(new University(), userId);
    }

    // authentication

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
