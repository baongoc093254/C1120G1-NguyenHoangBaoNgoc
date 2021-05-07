package com.example.repository;

import com.example.model.employee.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNameContaining(String name);
    User findByName(String name);
}
