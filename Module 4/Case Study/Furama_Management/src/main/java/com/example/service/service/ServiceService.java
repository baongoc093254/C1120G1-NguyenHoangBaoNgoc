package com.example.service.service;
import com.example.model.service.Service;

import java.util.List;


public interface ServiceService {
    List<Service> findAll();

    void save(Service service);

    Service findById(String id);

    List<Service> findAllByNameContaining(String name);

    void delete(Service service);
}
