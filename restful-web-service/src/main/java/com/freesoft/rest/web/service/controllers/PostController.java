package com.freesoft.rest.web.service.controllers;

import com.freesoft.rest.web.service.beans.Post;
import com.freesoft.rest.web.service.dao.PostDAOService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PostController {

    @Autowired
    private PostDAOService postService;

    @GetMapping(value = "/users/{userId}/posts/{postId}")
    public Post findPostById(@PathVariable int userId, @PathVariable int postId) {
        log.debug("### Enter: findPostById");
        Post post = postService.findPostById(userId, postId);
        return post;
    }

}
