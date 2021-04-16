package com.example.blog.controller;

import com.example.blog.model.Category;
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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;

    @GetMapping("/list")
    public String listCategory(Model model, @PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("category",categoryService.findAll(pageable));
        return "category_lists";
    }
    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("category",new Category());
        return "category_create";
    }
    @PostMapping("/save")
    public String create(Category category){
        categoryService.save(category);
        return "redirect:/category/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteForm(Model model, @PathVariable Integer id){
        model.addAttribute("category",categoryService.findById(id));
        return "category_delete";
    }
    @PostMapping("/delete")
    public String delete(Integer id){
        categoryService.remove(id);
        return "redirect:/category/list";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id,Model model){
        model.addAttribute("category",categoryService.findById(id));
        return "category_view";
    }
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id,Model model){
        model.addAttribute("category",categoryService.findById(id));
        return "category_edit";
    }
    @PostMapping("/edit")
    public String edit(Category category){
        categoryService.save(category);
        return "redirect:/category/list";
    }

}
