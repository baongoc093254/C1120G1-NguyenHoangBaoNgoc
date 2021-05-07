package com.example.service.contract;

import com.example.repository.AttachServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl implements AttachServiceService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public List<com.example.model.contract.AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
