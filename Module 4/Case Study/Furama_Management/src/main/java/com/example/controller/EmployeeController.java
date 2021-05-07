package com.example.controller;


import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.employee.User;
import com.example.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes()
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public String getEmployeePage(Model model, @PageableDefault(size = 4) Pageable pageable) {
        model.addAttribute("employeeList", employeeService.findAll(pageable));
        return "employee_list";
    }

    @GetMapping("/create")
    public String getCreateEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        User user = new User();
        return "employee/create";
    }

    @PostMapping("/save")
    public String createEmployee(@Validated Employee employee,BindingResult bindingResult,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("employee", employee);
            return "/employee/create";
        }
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Create Successfully !");
        return "redirect:/employee/";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);

        return "employee/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@Validated Employee employee, BindingResult bindingResult,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("employee", employee);
            return "/employee/edit";
        }
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Update Successfully !");
        return "redirect:/employee/";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        Employee employee = this.employeeService.findById(id);
        employeeService.delete(employee);
        redirectAttributes.addFlashAttribute("message", "Delete Successfully !");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchEmployee(@RequestParam("search") Optional<String> search, @PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Employee> employeeList;
        if (search.isPresent()) {
            model.addAttribute("search", search.get());
            employeeList = this.employeeService.findAllInputTex(search.get(), pageable);
        } else {
            employeeList = this.employeeService.findAll(pageable);
        }
        model.addAttribute("employeeList", employeeList);
        return "list";
    }


}
