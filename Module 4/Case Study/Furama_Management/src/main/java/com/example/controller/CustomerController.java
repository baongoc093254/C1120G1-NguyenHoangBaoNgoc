package com.example.controller;

import com.example.model.customer.Customer;
import com.example.service.contract.ContractService;
import com.example.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ContractService contractService;


    @GetMapping("")
    public String getListCustomer(Model model, @PageableDefault(size = 4) Pageable pageable) {
        model.addAttribute("listCustomer", customerService.findAll(pageable));
        return "list";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute("customer", new Customer());

        return "customer/create";
    }

    @PostMapping("/save")
    public String createCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Create Successfully !");
        return  "redirect:/customer/";
    }

    @GetMapping("/edit")
    public String getEditPage(@RequestParam("id") String id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);

        return "customer/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(Customer customer, Model model) {
        customerService.save(customer);
        model.addAttribute("message", "Update Successfully !");
        return "customer/edit";
    }
    @GetMapping("/delete")
    public String deleteForm(@RequestParam("id") String id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "customer/delete";
    }
    @PostMapping("/customer/delete")
    public String delete(@RequestParam("id") String id, RedirectAttributes redirectAttributes){
       Customer customer = this.customerService.findById(id);
        customerService.delete(customer);
        redirectAttributes.addFlashAttribute("message", "Delete Successfully !");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String findByAuthor(@RequestParam("inputSearch") String name, Model model, @PageableDefault(size = 3)Pageable pageable){
        model.addAttribute("customer",customerService.findAllByNameContaining(name,pageable));
        return "list";
    }
//    @GetMapping("/active")
//    public String getListActiveCustomer(Model model){
//        List<Contract> contracts = contractService.findAllByStartDateBeforeAndEndDateAfter(LocalDate.now().toString());
//
//        model.addAttribute("contracts", contracts);
//
//        return "/customer/active-customer";
//    }
//
//    @GetMapping("/search-active")
//    public String searchActiveCustomer(Model model, @RequestParam("search-data") String input){
//        List<Contract> contracts = contractService.findAllByStartDateBeforeAndEndDateAfterAndCustomer_Name(LocalDate.now().toString(), input);
//
//        model.addAttribute("contracts", contracts);
//
//        return "/customer/active-customer";
//    }



}
