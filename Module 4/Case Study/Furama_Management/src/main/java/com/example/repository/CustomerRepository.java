package com.example.repository;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer, String> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByNameContaining(String name,Pageable pageable);
    List<Customer> findAllByNameContaining(String name);
}
