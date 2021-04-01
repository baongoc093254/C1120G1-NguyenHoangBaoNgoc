package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, Product> productMap = new HashMap<>();
    static {
        productMap.put(1, new Product(1,"MacBook 2017", 1000, "Apple"));
        productMap.put(2, new Product(2,"Dell 2017", 800, "Dell"));
        productMap.put(3, new Product(3,"Vaio 2017", 1000, "Vaio"));
        productMap.put(4, new Product(4,"Asus 2017", 1000, "Asus"));
        productMap.put(5, new Product(5,"Alient 2021", 3000, "Apple"));
        productMap.put(6, new Product(6,"MacBook 2020", 1300, "Apple"));
    }
    @Override
    public List<Product> findAll() {
        return  new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
