package com.example.controller;

import com.example.model.contract.ContractDetail;
import com.example.service.contractdetail.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contractdetail")
public class ContractDetailController {

    @Autowired
    private ContractDetailService contractDetailService;

    @GetMapping("")
    public String getContractDetailPage(Model model, @PageableDefault(size = 4) Pageable pageable) {
        model.addAttribute("contractDetailList", contractDetailService.findAll(pageable));
        return "contract_detail_list";
    }

    @GetMapping("/create")
    public String createContractDetailPage(Model model) {
        model.addAttribute("contractDetail", new ContractDetail());
        return "/contractDetail/create";
    }
    @PostMapping("/save")
    public String createContractDetailPage(ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "Create Successfully !");
        return "redirect:/contractdetail/";
    }

}
