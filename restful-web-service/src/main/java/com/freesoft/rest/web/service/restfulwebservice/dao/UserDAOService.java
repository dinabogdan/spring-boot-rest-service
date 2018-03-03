package com.freesoft.rest.web.service.restfulwebservice.dao;

import com.freesoft.rest.web.service.restfulwebservice.beans.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserDAOService {

    private static int usersCount = 3;
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Joschua Bloch", new Date()));
        users.add(new User(2, "Bruce Eckel", new Date()));
        users.add(new User(3, "Brian Goetz", new Date()));
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
        return users.stream().filter(u -> u.getId() == id).findFirst().get();
    }

    public void removeUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
            }
        }
    }

}
