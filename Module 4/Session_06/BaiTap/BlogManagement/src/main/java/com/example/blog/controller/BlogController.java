package com.example.blog.controller;


import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public ModelAndView getHomePage() {
        List<Blog> blogList = this.blogService.findAll();
        return new ModelAndView("index","blogList", blogList);
    }

    @GetMapping("/create")
    public String getCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }
    @PostMapping("/save")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create Successfully !");
        return "redirect:/";
    }

    @GetMapping("/blog/{id}/edit")
    public String getEditPage(@PathVariable int id, Model model) {
        model.addAttribute("editBlog", blogService.findById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String editBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Edit successfully !");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteBlog(@RequestParam int id) {
        blogService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/blog/{id}/view")
    public String getViewPage(@PathVariable int id, Model model) {
        model.addAttribute("viewBlog", blogService.findById(id));
        return "detail";
    }


}
