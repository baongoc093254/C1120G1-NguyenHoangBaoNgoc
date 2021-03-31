package com.example.service.impl;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Employee findById(String id) {
        return null;
    }
}
