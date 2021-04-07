package com.example.formregister.service;


import com.example.formregister.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    void deleteById(int id);
    void save(User user);
    List<User> searchByName(String name);
}
