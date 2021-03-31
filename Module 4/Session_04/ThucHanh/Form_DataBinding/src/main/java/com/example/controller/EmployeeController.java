package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("employee", new Employee());
        return "create";
    }

    @PostMapping("/create")
    public String createEmployee(Model model, @ModelAttribute Employee employee) {
       model.addAttribute("employee", employee);

        return "index";
    }
}
