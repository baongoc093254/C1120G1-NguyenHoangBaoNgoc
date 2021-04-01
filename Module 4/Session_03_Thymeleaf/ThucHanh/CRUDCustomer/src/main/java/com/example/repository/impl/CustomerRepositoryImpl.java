package com.example.repository.impl;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private static Map<Integer, Customer> customerList = new HashMap<>();
    static {
        customerList.put(1, new Customer(1, "Hoang", "hoang@gmail.com", "Quang Nam"));
        customerList.put(2, new Customer(2, "Sang", "hoang@gmail.com", "Da Nang"));
        customerList.put(3, new Customer(3, "Vi", "hoang@gmail.com", "Da Nang"));
        customerList.put(4, new Customer(4, "Thuan", "hoang@gmail.com", "Hue"));
        customerList.put(5, new Customer(5, "Phuc", "hoang@gmail.com", "Da Nang"));
        customerList.put(6, new Customer(6, "Nghia", "hoang@gmail.com", "Ha Noi"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerList.values());
    }

    @Override
    public void save(Customer customer) {
        customerList.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerList.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customerList.remove(id);
    }
}
