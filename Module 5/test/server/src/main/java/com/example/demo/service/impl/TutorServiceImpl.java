package com.example.demo.service.impl;

import com.example.demo.model.Tutor;
import com.example.demo.repository.TutorRepository;
import com.example.demo.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {
    @Autowired
    private TutorRepository tutorRepository;
    @Override
    public List<Tutor> findAll() {
        return tutorRepository.findAll();
    }
}
