package com.example.service.employee;

import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(Integer id);

    void delete(Employee employee);

    Page<Employee> findAllByNameContaining(String name, Pageable pageable);

    Boolean emailIsUnique(String email);

    Page<Employee> findAllInputTex(String search,Pageable pageable);
}
