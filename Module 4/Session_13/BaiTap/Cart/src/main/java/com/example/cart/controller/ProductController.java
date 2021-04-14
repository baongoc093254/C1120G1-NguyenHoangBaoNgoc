package com.example.cart.controller;


import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("list", productService.findAll());
        return "index";
    }

    @GetMapping("/product/{id}/detail")
    public String getDetailPage(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }

    @PostMapping("/product/{id}/bought")
    public String addProductToCart(@PathVariable("id") Integer id, Model model, @ModelAttribute ("cart") Cart cart) {
        Product product = productService.findById(id);
        cart.addProductToCart(product);
        model.addAttribute("product", product);
        model.addAttribute("message", "Add to cart successfully !");
        return "detail";
    }
    @GetMapping("/cart")
    public String getCartPage(@ModelAttribute("cart") Cart cart, Model model) {
        Map<Product, Integer> cartList = cart.getCart();
        model.addAttribute("cartList", cartList);
        return "cart";
    }
    @GetMapping("/cart/{id}/delete")
    public String removeProduct(@ModelAttribute("cart") Cart cart, @PathVariable("id") Integer id) {
        cart.removeProduct(productService.findById(id));
        return "redirect:/cart";
    }
}
