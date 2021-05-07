package com.example.controller;

import com.example.model.contract.Contract;
import com.example.service.contract.ContractService;
import com.example.service.contractdetail.ContractDetailService;
import com.example.service.customer.CustomerService;
import com.example.service.employee.EmployeeService;
import com.example.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ContractDetailService contractDetailService;


    @GetMapping("")
    public String getContractPage(Model model,  @PageableDefault(size = 4) Pageable pageable) {
        model.addAttribute("contractLists", contractService.findAll(pageable));
        return "contract_list";
    }

    @GetMapping("/create")
    public String getCreateContract(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("listService", serviceService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        return "/contract/create";
    }

    @PostMapping("/save")
    public String createContract(@Validated @ModelAttribute(name = "contract") Contract contract, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerList", customerService.findAll());
            model.addAttribute("employeeList", employeeService.findAll());
            model.addAttribute("listService", serviceService.findAll());
            model.addAttribute("contract", contract);
            return "/contract/create";
        }
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Create Successfully !");
        return "redirect:/contract/";
    }
}
