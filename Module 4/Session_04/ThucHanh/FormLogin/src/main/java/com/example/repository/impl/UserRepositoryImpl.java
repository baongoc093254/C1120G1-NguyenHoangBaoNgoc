package com.example.repository.impl;

import com.example.model.Login;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl  implements UserRepository {
    static List<User> userList = new ArrayList<>();
    static {
        userList.add(new User("hoang", "123", "Hoang", "hoang@gmail.com", 22));
        userList.add(new User("sang", "123", "Hoang", "hoang@gmail.com", 23));
        userList.add(new User("thuan", "123", "Hoang", "hoang@gmail.com", 24));
        userList.add(new User("nghia", "123", "Hoang", "hoang@gmail.com", 25));
        userList.add(new User("vi", "123", "Hoang", "hoang@gmail.com", 26));
        userList.add(new User("phuc", "123", "Hoang", "hoang@gmail.com", 27));
    }

    @Override
    public User checkLogin(Login login) {
        for (User user: userList) {
            if (user.getAccount().equals(login.getAccount())
            && user.getPassword().equals(login.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
