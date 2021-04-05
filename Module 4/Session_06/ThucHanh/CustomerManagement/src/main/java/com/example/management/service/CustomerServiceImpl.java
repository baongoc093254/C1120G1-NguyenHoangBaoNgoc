package com.example.management.service;

import com.example.management.model.Customer;
import com.example.management.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById((long) id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById((long) id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return null;
    }



}
