package com.example.library.model;


import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    private Integer id;
    private String nameBook;
    private Integer quantity;

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
