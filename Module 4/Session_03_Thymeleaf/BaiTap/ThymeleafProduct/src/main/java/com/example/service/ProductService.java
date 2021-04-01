package com.example.service;

import com.example.model.Product;
import com.example.repository.CRUDRepository;

import java.util.List;

public interface ProductService extends CRUDRepository<Product> {
    @Override
    List<Product> findAll();

    @Override
    void save(Product product);

    @Override
    Product findById(int id);

    @Override
    void update(int id, Product product);

    @Override
    void remove(int id);
}
