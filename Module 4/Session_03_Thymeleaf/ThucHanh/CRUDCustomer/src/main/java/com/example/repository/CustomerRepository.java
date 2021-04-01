package com.example.repository;

import com.example.model.Customer;

import java.util.List;

public interface CustomerRepository extends CRUDRepository<Customer> {
    @Override
    List<Customer> findAll();

    @Override
    void save(Customer customer);

    @Override
    Customer findById(int id);

    @Override
    void update(int id, Customer customer);

    @Override
    void remove(int id);
}
