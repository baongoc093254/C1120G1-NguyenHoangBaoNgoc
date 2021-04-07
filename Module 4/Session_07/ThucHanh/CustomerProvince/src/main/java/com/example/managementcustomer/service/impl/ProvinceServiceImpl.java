package com.example.managementcustomer.service.impl;

import com.example.managementcustomer.model.Province;
import com.example.managementcustomer.repository.ProvinceRepository;
import com.example.managementcustomer.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceRepository repository;

    @Override
    public List<Province> findAll() {
        return repository.findAll();
    }

    @Override
    public Province findById(Integer id) {
        return  repository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        repository.save(province);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }
}
