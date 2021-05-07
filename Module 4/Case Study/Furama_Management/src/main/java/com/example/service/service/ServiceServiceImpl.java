package com.example.service.service;

import com.example.model.service.Service;
import com.example.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(Service service) {
            serviceRepository.save(service);
    }

    @Override
    public Service findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Service> findAllByNameContaining(String name) {
        return serviceRepository.findAllByNameContaining(name);
    }

    @Override
    public void delete(Service service) {
        serviceRepository.delete(service);
    }
}
