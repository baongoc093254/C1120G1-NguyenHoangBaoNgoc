package com.example.demo.service.impl;

import com.example.demo.model.SmartPhone;
import com.example.demo.repository.SmartPhoneRepository;
import com.example.demo.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartPhoneServiceImpl implements SmartPhoneService {
    @Autowired
    private SmartPhoneRepository smartPhoneRepository;

    @Override
    public Page<SmartPhone> findAll(Pageable pageable) {
        return smartPhoneRepository.findAll(pageable);
    }

    @Override
    public List<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(Integer id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public void save(SmartPhone phone) {
        smartPhoneRepository.save(phone);
    }

    @Override
    public void remove(Integer id) {
        smartPhoneRepository.deleteById(id);
    }

    @Override
    public void update(SmartPhone smartPhone) {
        smartPhoneRepository.save(smartPhone);
    }
}
