package com.freesoft.rest.web.service.controllers;

import com.freesoft.rest.web.service.beans.User;
import com.freesoft.rest.web.service.dao.UserDAOService;
import com.freesoft.rest.web.service.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserDAOService userService;

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        log.debug("### Enter: getAllUsers");
        return userService.findAll();
    }

    @GetMapping(value = "/users/{userId}")
    public Resource<User> getSpecificUser(@PathVariable int userId) {
        log.debug("### Enter: getSpecificUser");
        User user = userService.findOne(userId);
        if (user == null) {
            throw new UserNotFoundException("The user with id: " + userId + " wasn't found!");
        }

        Resource<User> resource = new Resource<>(user);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @PutMapping(value = "/users")
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
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
    public void deleteUser(@PathVariable int userId) {
        log.debug("### Enter: deleteUserById");
        User user = userService.removeUserById(userId);
        if(user == null){
            throw new UserNotFoundException("The user with id: " + userId + " wasn't found!");
        }
    }
}
