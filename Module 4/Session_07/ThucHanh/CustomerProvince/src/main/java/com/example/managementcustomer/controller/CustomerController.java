package com.example.managementcustomer.controller;

import com.example.managementcustomer.model.Customer;
import com.example.managementcustomer.model.Province;
import com.example.managementcustomer.service.CustomerService;
import com.example.managementcustomer.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    @Autowired
    ProvinceService provinceService;

    @GetMapping("/")
    public String getHomePage(@PageableDefault(value = 2) Pageable pageable,Model model) {

        List<Province> provinceList =  provinceService.findAll();
        Page<Customer> customerList = customerService.findAll(pageable);
        model.addAttribute("customer", new Customer());
        model.addAttribute("provinceList", provinceList);
        model.addAttribute("customerList", customerList);
        return "index";
    }

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        List<Province> provinceList = provinceService.findAll();
        model.addAttribute("provinceList",provinceList);
        model.addAttribute("customer", new Customer());
        return "create";
    }
    @PostMapping("/save")
    public String createCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "create successfully !");
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/edit")
    public String getCreateForm(@PathVariable int id, Model model) {
        List<Province> provinceList = provinceService.findAll();
        model.addAttribute("provinceList", provinceList);
        model.addAttribute("editCustomer", customerService.findById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes, Model model) {
        customerService.save(customer);
        model.addAttribute("provinces",provinceService.findAll());
        redirectAttributes.addFlashAttribute("message", "Edit successfully !");
        return "redirect:/";

    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam Integer id) {
        customerService.remove(id);
        return "redirect:/";
    }

}
