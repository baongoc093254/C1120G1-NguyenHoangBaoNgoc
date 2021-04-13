package com.example.demo.service;

import com.example.demo.model.SmartPhone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SmartPhoneService {
    Page<SmartPhone> findAll(Pageable pageable);
    List<SmartPhone> findAll();
    SmartPhone findById(Integer id);
    void save(SmartPhone phone);
    void remove(Integer id);
    void update(SmartPhone smartPhone);

}
