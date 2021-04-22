package com.example.controller;

import com.example.model.contract.Contract;
import com.example.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping("")
    public String getContractPage(Model model,  @PageableDefault(size = 4) Pageable pageable) {
        model.addAttribute("contractLists", contractService.findAll(pageable));
        return "contract_list";
    }

    @GetMapping("/create")
    public String getCreateContract(Model model) {
        model.addAttribute("contract", new Contract());
        return "/contract/create";
    }

    @PostMapping("/save")
    public String createContract(Contract contract, RedirectAttributes redirectAttributes) {
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Create Successfully !");
        return "redirect:/contract/";
    }
}
