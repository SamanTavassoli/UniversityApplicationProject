package com.thesamans.universityapplicationproject.webapi.controllers;

import com.thesamans.universityapplicationproject.model.users.User;
import com.thesamans.universityapplicationproject.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/NOT_SURE_YET") // todo: think of good mapping
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @GetMapping(value = "/{userId}")
    public User getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }
}
