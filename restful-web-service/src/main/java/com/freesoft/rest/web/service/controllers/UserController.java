package com.freesoft.rest.web.service.controllers;

import com.freesoft.rest.web.service.beans.User;
import com.freesoft.rest.web.service.dao.UserDAOService;
import com.freesoft.rest.web.service.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserDAOService userService;

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        log.debug("### Enter: getAllUsers");
        return userService.findAll();
    }

    @GetMapping(value = "/users/{userId}")
    public User getSpecificUser(@PathVariable int userId) {
        log.debug("### Enter: getSpecificUser");
        User user = userService.findOne(userId);
        if (user == null) {
            throw new UserNotFoundException("The user with id: " + userId + " wasn't found!");
        }
        return user;
    }

    @PutMapping(value = "/users")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        log.debug("### Enter: addUser");
        User savedUser = userService.save(user);
        URI uriLocation = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(savedUser.getId()).
                toUri();
        return ResponseEntity.
                created(uriLocation).
                build();
    }

    @DeleteMapping(value = "/users/{userId}")
    public void deleteUserById(@PathVariable int userId) {
        log.debug("### Enter: deleteUserById");
        userService.removeUser(userId);
    }
}
