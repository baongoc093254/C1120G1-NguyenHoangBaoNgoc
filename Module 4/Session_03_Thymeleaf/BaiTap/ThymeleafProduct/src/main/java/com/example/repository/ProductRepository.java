package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface ProductRepository extends CRUDRepository<Product> {
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
