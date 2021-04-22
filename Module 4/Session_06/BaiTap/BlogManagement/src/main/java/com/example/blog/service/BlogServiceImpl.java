package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.BlogRepository;
import com.example.blog.until.DateUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import java.util.List;

@Service
public class BlogServiceImpl  implements BlogService{

    @Autowired
    BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null) {
            blog.setDateUpload(DateUntil.getCurrentDate());
        }
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> searchByName(String name) {
        return null;
    }
}
