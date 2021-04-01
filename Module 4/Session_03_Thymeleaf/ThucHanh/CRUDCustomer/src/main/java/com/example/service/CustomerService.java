package com.example.service;

import com.example.model.Customer;
import com.example.repository.CRUDRepository;

import java.util.List;


public interface CustomerService extends CRUDRepository<Customer> {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
