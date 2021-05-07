package com.example.repository;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer, String> {
    Page<Customer> findAll(Pageable pageable);

    @Query(value ="SELECT * " +
            "from Customer" +
            "where concat(customer_name, customer_address, customer_id, customer_email) like %?1%",
            nativeQuery = true)
    Page<Customer> findAllByKey(String key, Pageable pageable);


    Page<Customer> findAllByNameContaining(String name,Pageable pageable);
    List<Customer> findAllByNameContaining(String name);
}
