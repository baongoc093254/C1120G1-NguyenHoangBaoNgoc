package com.example.controller;


import com.example.model.employee.Employee;
import com.example.model.employee.User;
import com.example.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
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
    public String getCreateEmployee( Model model) {
            model.addAttribute("employee", new Employee());
            User user = new User();
            return "employee/create";
        }

        @PostMapping("/save")
    public String createEmployee(Employee employee, RedirectAttributes redirectAttributes) {
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Create Successfully !");
            return "redirect:/employee/";
        }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable("id") Integer id, Model model) {
        Employee  employee = employeeService.findById(id);
        model.addAttribute("employee", employee);

        return "employee/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(Employee employee, Model model) {
        employeeService.save(employee);
        model.addAttribute("message", "Update Successfully !");
        return "employee/edit";
    }
    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") Integer id, Model model){
        model.addAttribute("employee",employeeService.findById(id));
        return "employee/delete";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes){
        Employee employee = this.employeeService.findById(id);
        employeeService.delete(employee);
        redirectAttributes.addFlashAttribute("message", "Delete Successfully !");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String findByAuthor(@RequestParam("inputSearch") String name, Model model, @PageableDefault(size = 4) Pageable pageable){
        model.addAttribute("employeeList",employeeService.findAllByNameContaining(name,pageable));
        return "employee_list";
    }


}
