package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @GetMapping("/")
    public ModelAndView getHome() {
        List<Customer> customerList = this.customerService.findAll();
        return new ModelAndView("index","customerList", customerList);

    }

    @GetMapping("/views/create")
    public ModelAndView createCustomer(Model model) {
        return new ModelAndView("create", "customer", new Customer());

    }

    @PostMapping("/views/save")
    public ModelAndView save(Customer customer) {
        this.customerService.save(customer);
        return getHome();
    }

    @GetMapping("/customer/{id}/edit")
    public String getEditCustomer(@PathVariable int id, Model model) {
        Customer customer = this.customerService.findById(id);
        model.addAttribute("edit", customer);
        return "edit";

    }

    @PostMapping("/customer/update")
    public String update(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.update(customer.getId(),customer);
        redirectAttributes.addFlashAttribute("message", "Successfully update !");

        return "redirect:/";
    }

    @GetMapping("/customer/{id}/delete")
    public String getDeleteCustomer(@PathVariable int id, Model model) {
        Customer customer = this.customerService.findById(id);
        model.addAttribute("delete", customer);
        return "delete";
    }

    @PostMapping("/customer/delete")
    public String delete(@ModelAttribute("product") Customer customer, RedirectAttributes redirectAttributes){
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("message", "Successfully deleted !");

        return "redirect:/";
    }


}
