package com.example.service.impl;

import com.example.model.Login;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User checkLogin(Login login) {
     return    userRepository.checkLogin(login);
    }
}
