package com.example.service;

import com.example.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    void save(Employee employee);
    void deleteById(String id);
    Employee findById(String id);
}
