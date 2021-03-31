package com.example.service.impl;

import com.example.model.Email;
import com.example.repository.EmailRepository;
import com.example.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    EmailRepository emailRepository;

    @Override
    public List<String> getLanguageList() {
        return emailRepository.getLanguageList();
    }

    @Override
    public List<Integer> getPageSizeList() {
        return emailRepository.getPageSizeList();
    }

    @Override
    public void save(Email email) {
        emailRepository.save(email);
    }
}
