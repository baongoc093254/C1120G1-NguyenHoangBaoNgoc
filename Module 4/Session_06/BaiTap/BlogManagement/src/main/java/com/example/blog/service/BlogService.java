package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(Integer id);
    void deleteById(Integer id);
    void save(Blog blog);
    List<Blog> searchByName(String name);
}
