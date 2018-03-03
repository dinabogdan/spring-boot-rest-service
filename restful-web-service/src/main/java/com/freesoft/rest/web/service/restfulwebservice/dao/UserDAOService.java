package com.freesoft.rest.web.service.restfulwebservice.dao;

import com.freesoft.rest.web.service.restfulwebservice.beans.Post;
import com.freesoft.rest.web.service.restfulwebservice.beans.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Repository
public class UserDAOService {

    private static int usersCount = 3;

    @Getter(AccessLevel.PUBLIC)
    private static List<User> users = new ArrayList<>();

    static {
        List<Post> firstUserPosts = new ArrayList<>();
        firstUserPosts.add(new Post(1, "This is the first post!", new Date()));
        firstUserPosts.add(new Post(2, "This is the second post!", new Date()));

        List<Post> secondUserPosts = new ArrayList<>();
        secondUserPosts.add(new Post(3, "This is the third post!", new Date()));
        secondUserPosts.add(new Post(4, "This is the fourth post!", new Date()));
        secondUserPosts.add(new Post(5, "This it the fifth post!", new Date()));

        List<Post> thirdUserPosts = new ArrayList<>();
        thirdUserPosts.add(new Post(6, "This is the sixth post!", new Date()));

        users.add(new User(1, "Joschua Bloch", new Date(), firstUserPosts));
        users.add(new User(2, "Bruce Eckel", new Date(), secondUserPosts));
        users.add(new User(3, "Brian Goetz", new Date(), thirdUserPosts));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void removeUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
            }
        }
    }

}
