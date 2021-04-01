package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping("/")
    public String getHome(Model model) {
        List<Product> productList = this.productService.findAll();
        model.addAttribute("productList",productList);
        return "index";
    }

    @GetMapping("/product/create")
    public String getCreateProduct(Model model) {
       model.addAttribute("product", new Product());
       return "create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Create new product !");
        return "index";
    }

    @GetMapping("/product/{id}/edit")
    public String getUpdateProduct(@PathVariable int id, Model model) {
        Product product = this.productService.findById(id);
        model.addAttribute("editProduct", product);
        return "edit";
    }

    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("message", "Edit infor product !");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/delete")
    public String getDeleteProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";

    }

    @PostMapping("/delete")
    public String deleteProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message", "Delete Product !");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/detail")
    public String getDetailProduct(@PathVariable int id, Model model) {
        model.addAttribute("product",productService.findById(id));
        return "detail";
    }

}
