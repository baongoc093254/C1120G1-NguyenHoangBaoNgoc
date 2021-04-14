package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findAll();
    Blog findById(Integer id);
    void save(Blog blog);
    void remove(Integer id);
    Page<Blog> findByAuthorContaining(String author,Pageable pageable);
}
