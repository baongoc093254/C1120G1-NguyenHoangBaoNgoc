package com.example.repository;

import com.example.model.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository  extends JpaRepository<Service, String> {
    List<Service> findAllByNameContaining(String name);
}
