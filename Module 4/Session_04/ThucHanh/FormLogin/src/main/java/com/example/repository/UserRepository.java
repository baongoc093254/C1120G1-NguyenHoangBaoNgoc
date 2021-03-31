package com.example.repository;

import com.example.model.Login;
import com.example.model.User;

public interface UserRepository {
     User checkLogin(Login login);
}
