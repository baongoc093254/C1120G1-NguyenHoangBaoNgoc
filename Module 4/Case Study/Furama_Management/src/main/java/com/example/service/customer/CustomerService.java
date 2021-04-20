package com.example.service.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(String id);

    void delete(Customer customer);

    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

}
