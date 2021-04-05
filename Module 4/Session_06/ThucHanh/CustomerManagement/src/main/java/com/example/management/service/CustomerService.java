package com.example.management.service;

import com.example.management.model.Customer;

import java.util.List;

public interface CustomerService  {
    List<Customer> findAll();
    Customer findById(Long id);
    void deleteById(Long id);
    void save(Customer customer);
    List<Customer> searchByName(String name);
}
