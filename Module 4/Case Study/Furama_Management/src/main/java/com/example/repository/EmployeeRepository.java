package com.example.repository;


import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findByNameContaining(String name,Pageable pageable);
    List<Employee> findByNameContaining(String name);
}

