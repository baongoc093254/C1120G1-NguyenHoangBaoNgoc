package com.example.repository;


import java.util.List;

public interface CRUDRepository<T> {
    List<T> findAll();

    void save(T t);

    T findById(int id);

    void update(int id, T t);

    void remove(int id);
}

