package com.example.repository;

import com.example.model.Email;

import java.util.List;

public interface EmailRepository {
    List<String> getLanguageList();
    List<Integer> getPageSizeList();
    void save(Email email);
}
