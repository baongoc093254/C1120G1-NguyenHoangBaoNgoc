package com.example.repository.impl;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl  implements EmployeeRepository {

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
