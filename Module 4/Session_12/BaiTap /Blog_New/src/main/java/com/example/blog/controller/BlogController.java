package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String blogList(Model model, @PageableDefault(size = 4,sort = "writeDate")Pageable pageable) {
        model.addAttribute("blog", blogService.findAll(pageable));
        return "list";
    }

    @GetMapping("/blog/create")
    public String createForm(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("category",categoryService.findAll());
        return "create";
    }
    @PostMapping("/blog/save")
    public String create(Blog blog){
        blog.setWriteDate(String.format("yyyy/MM/dd"));
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/blog/delete/{id}")
    public String deleteForm(Model model, @PathVariable Integer id){
        model.addAttribute("blog",blogService.findById(id));
        return "delete";
    }
    @PostMapping("/blog/delete")
    public String delete(Integer id){
        blogService.remove(id);
        return "redirect:/";
    }
    @GetMapping("/blog/view/{id}")
    public String view(@PathVariable Integer id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "view";
    }
    @GetMapping("/blog/edit/{id}")
    public String editForm(@PathVariable Integer id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        model.addAttribute("category",categoryService.findAll());
        return "edit";
    }
    @PostMapping("/blog/edit")
    public String edit(Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/search")
    public String findByAuthor(@RequestParam("inputSearch") String author, Model model, @PageableDefault(size = 3,sort = "writeDate")Pageable pageable){
        model.addAttribute("blog",blogService.findByAuthorContaining(author,pageable));
        return "list";
    }
}
