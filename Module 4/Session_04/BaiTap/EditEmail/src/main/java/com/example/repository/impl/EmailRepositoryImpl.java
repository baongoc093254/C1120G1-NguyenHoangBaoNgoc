package com.example.repository.impl;

import com.example.model.Email;
import com.example.repository.EmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmailRepositoryImpl implements EmailRepository {
    static List<String> languageList = new ArrayList<>();
    static List<Integer> pageList = new ArrayList<>();
    static List<Email> emailList = new ArrayList<>();
    static {
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");

        pageList.add(5);
        pageList.add(10);
        pageList.add(15);
        pageList.add(25);
        pageList.add(50);
        pageList.add(100);
    }
     @Override
    public List<String> getLanguageList() {
        return languageList;
    }

    @Override
    public List<Integer> getPageSizeList() {
        return pageList;
    }

    @Override
    public void save(Email email) {
        emailList.add(email);
    }
}
