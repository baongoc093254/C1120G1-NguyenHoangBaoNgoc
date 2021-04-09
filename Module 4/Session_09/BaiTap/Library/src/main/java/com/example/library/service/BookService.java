package com.example.library.service;

import com.example.library.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Integer id);

    void save (Book book);
}
