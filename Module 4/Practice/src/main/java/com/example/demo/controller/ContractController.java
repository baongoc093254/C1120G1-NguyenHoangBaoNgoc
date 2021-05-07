package com.example.demo.controller;

import com.example.demo.model.Contract;
import com.example.demo.service.ContractService;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductTypeService;
import javafx.scene.control.Control;
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

import java.util.List;

@Controller
@RequestMapping({"/contract",""})
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("")
    public String getContractList(Model model, @PageableDefault(value = 3)Pageable pageable) {
        model.addAttribute("productList", productService.findAll());
        model.addAttribute("contractList", contractService.findAll(pageable));

        return "contract_list";
    }


    @GetMapping("/edit")
    public String getEditPage(@RequestParam("id") int id, Model model) {
        model.addAttribute("contract", contractService.findById(id));
        model.addAttribute("productList", productService.findAll());
        model.addAttribute("productTypeList", productTypeService.findAll());
        return "edit";
    }

    @PostMapping("/update")
    public String updateCustomer( @ModelAttribute("contract") Contract contract, BindingResult bindingResult ,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("contract", contract);
//            model.addAttribute("productTypeList", productTypeService.findAll());
//            return "edit";
//        }
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Update Successfully !");
        return "redirect:/contract/";
    }

    @PostMapping("/searchProduct")
    public String getProductByDate(@RequestParam(name = "startDate") String startDate,
                                   @RequestParam(name = "endDate") String endDate, Model model,
                                   @PageableDefault(value = 3) Pageable pageable) {
        Page<Contract> contractList = this.contractService.findByDateBuy(startDate, endDate, pageable);
        model.addAttribute("contractList", contractList);
        return "search";
    }

    @PostMapping("/searchLimit")
    public String getProductLimit(@RequestParam(name = "number") Integer limitNumber,
                                  Model model) {
        List<Contract> contractLimit = this.contractService.findByLimit(limitNumber);
        model.addAttribute("contractLimit", contractLimit);
        return "searchLimit";

    }

}
