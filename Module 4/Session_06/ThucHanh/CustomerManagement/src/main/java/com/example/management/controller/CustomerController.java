package com.example.management.controller;


import com.example.management.model.Customer;
import com.example.management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ModelAndView getHomePage() {
        List<Customer> customerList = this.customerService.findAll();
        return new ModelAndView("index","customerList",customerList);
    }

    @GetMapping("/customer/create")
    public String getCreatePage(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String createCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Successfully created !");
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/edit")
    public String getEditCustomer(@PathVariable Long id, Model model) {
       Customer customer = this.customerService.findById(id);
       model.addAttribute("editCustomer", customer);
       return "edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Update done !");
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/view")
    public String getDetailPage(@PathVariable Long id, Model model) {
        Customer customer = this.customerService.findById(id);
        model.addAttribute("viewCustomer",customer);
        return "detail";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam Long id) {
        customerService.deleteById(id);
        return "redirect:/";
    }
}
