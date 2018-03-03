package com.freesoft.rest.web.service.restfulwebservice.controllers;

import com.freesoft.rest.web.service.restfulwebservice.beans.User;
import com.freesoft.rest.web.service.restfulwebservice.dao.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAOService userService;

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/users/{userId}")
    public User getSpecificUser(@PathVariable int userId) {
        return userService.findOne(userId);
    }

    @PutMapping(value = "/users")
    public void addUser(@RequestBody User user) {
        User savedUser = userService.save(user);
    }

    @DeleteMapping(value = "/users/{userId}")
    public void deleteUserById(@PathVariable int userId){
        userService.removeUser(userId);
    }
}
