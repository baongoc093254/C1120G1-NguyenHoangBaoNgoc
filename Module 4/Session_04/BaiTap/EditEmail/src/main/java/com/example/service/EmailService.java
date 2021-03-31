package com.example.service;

import com.example.model.Email;

import java.util.List;

public interface EmailService {
    List<String> getLanguageList();
    List<Integer> getPageSizeList();
    void save(Email email);
}
