package com.thesamans.universityapplicationproject.controllers;

import com.thesamans.universityapplicationproject.model.authentication.AuthenticationRequest;
import com.thesamans.universityapplicationproject.model.authentication.AuthenticationResponse;
import com.thesamans.universityapplicationproject.model.users.MyUserDetails;
import com.thesamans.universityapplicationproject.model.users.RegistrationUser;
import com.thesamans.universityapplicationproject.services.MyUserDetailsService;
import com.thesamans.universityapplicationproject.services.RegistrationService;
import com.thesamans.universityapplicationproject.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password");
        }

        final MyUserDetails myUserDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(myUserDetails);

        // what is sent back to the front end as a confirmation of login
        return ResponseEntity.ok(new AuthenticationResponse(myUserDetails.getUsername(), myUserDetails.getUserType(), jwt));
    }

    @PostMapping(value = "/register")
    public boolean register(@RequestBody RegistrationUser user) {
        return registrationService.registerUser(user);
    }
}
