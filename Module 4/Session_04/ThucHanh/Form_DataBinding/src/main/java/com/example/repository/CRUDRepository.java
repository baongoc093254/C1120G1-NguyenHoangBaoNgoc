package com.example.repository;

import java.util.List;

public interface CRUDRepository<T> {
    List<T> findAll();
    void save(T t);
    void deleteById(String id);
    T findById(String id);
}
