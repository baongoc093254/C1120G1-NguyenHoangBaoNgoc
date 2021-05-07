package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    List<Product> findAll();

    void save(Product Product);

    Product findById(Integer id);

    void remove(Integer id);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
