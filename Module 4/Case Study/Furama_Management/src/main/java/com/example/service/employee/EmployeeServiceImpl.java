package com.example.service.employee;

import com.example.model.employee.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Employee employee) {
            employeeRepository.delete(employee);
    }

    @Override
    public Page<Employee> findAllByNameContaining(String name, Pageable pageable) {
        return employeeRepository.findAllByNameContaining(name,pageable);
    }



    @Override
    public Boolean emailIsUnique(String email) {
        return null;
    }

    @Override
    public Page<Employee> findAllInputTex(String search, Pageable pageable) {
        return employeeRepository.findAllInputTex(search,pageable);
    }


}
