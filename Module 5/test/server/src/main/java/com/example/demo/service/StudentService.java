package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student save(Student student);

    Student findById(Integer id);

    void delete(Integer id);

    List<Student> findAllByNameContaining(String name);
}
