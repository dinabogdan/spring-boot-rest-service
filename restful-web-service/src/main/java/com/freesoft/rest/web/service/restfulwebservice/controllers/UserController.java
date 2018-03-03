package com.freesoft.rest.web.service.restfulwebservice.controllers;

import com.freesoft.rest.web.service.restfulwebservice.beans.User;
import com.freesoft.rest.web.service.restfulwebservice.dao.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAOService userService;

    @GetMapping(value = "/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping(value = "/users/{userId}")
    public User getSpecificUser(@PathVariable int userId){
        return userService.findOne(userId);
    }

    @PutMapping(value="/users")
    public User addUser(){
        User user = new User(4, "Dennis Ritchie", new Date());
        return userService.save(user);
    }
}
