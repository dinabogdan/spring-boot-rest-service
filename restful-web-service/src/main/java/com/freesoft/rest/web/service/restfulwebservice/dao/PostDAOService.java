package com.freesoft.rest.web.service.restfulwebservice.dao;


import com.freesoft.rest.web.service.restfulwebservice.beans.Post;
import com.freesoft.rest.web.service.restfulwebservice.beans.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class PostDAOService {

    public Post findPostById(int userId, int postId) {
        for (User user : UserDAOService.getUsers()) {
            if (user.getId() == userId) {
                for (Post post : user.getPosts()) {
                    if (post.getPostId() == postId) {
                        return post;
                    }
                }
            }
        }
        return null;
    }

}
