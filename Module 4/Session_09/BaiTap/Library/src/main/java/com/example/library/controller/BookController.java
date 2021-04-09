package com.example.library.controller;


import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

//    @GetMapping("/")
//    public String getHomePage(Model model) {
//        List<Book> bookList = this.bookService.findAll();
//        model.addAttribute("bookList", bookList);
//        return "index";
//    }
//
//    @GetMapping("/book/{id}/detail")
//    public String getDetailPage(@PathVariable Integer id, Model model){
//        Book book = bookService.findById(id);
//        model.addAttribute("book", book);
//
//        return "detail";
//    }
//    @GetMapping("/book/{id}/detail")
//    public String getDetailPage(@PathVariable int id, Model model) {
//        Book book = bookService.findById(id);
//        model.addAttribute("book", book);
//        return "detail";
//    }


//    @GetMapping("/book/{id}/borrow")
//    public String getBorrow(@PathVariable int id, Model model) {
//        Book book = this.bookService.findById(id);
//        if (book.getQuantity() == null) {
//            model.addAttribute("message", "Sorry ! This book does not exist now . Please come back tomorrow !");
//            return "error";
//        }
//        book.setQuantity(book.getQuantity() - 1);
//        bookService.save(book);
//        return "redirect:/";
//    }
//
//    @GetMapping("/give-back")
//    public String giveBack(@RequestParam int id, Model model) {
//        Book book = this.bookService.findById(id);
//        if (book.getQuantity() == null) {
//            model.addAttribute("message", "Sorry ! This book does not exist now . Please come back tomorrow !");
//            return "error";
//        }
//        book.setQuantity(book.getQuantity() + 1);
//        return "redirect:/";
//    }

    @GetMapping("")
    public String list(Model model){
        model.addAttribute("bookList",bookService.findAll());
        return "index";
    }
    @GetMapping("/book/{id}/borrow")
    public String borrow(@PathVariable Integer id,Model model){
        Book book = bookService.findById(id);
        book.setQuantity(book.getQuantity() -1);
        if(book.getQuantity() < 0){
            model.addAttribute("message","Sorry ! This book does not exist now . Please come back tomorrow !");
            return "error";
        }

        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/book/give_back")
    public String giveBack(@RequestParam Integer id,Model model){
        Book book = bookService.findById(id);
        if(book == null){
            model.addAttribute("message","We haven't that id !");
            return "error";
        }
        book.setQuantity(book.getQuantity()+1);
        bookService.save(book);

        return "redirect:/";
    }


}
