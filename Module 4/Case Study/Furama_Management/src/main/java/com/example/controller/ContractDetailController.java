package com.example.controller;

import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.service.contract.AttachServiceService;
import com.example.service.contract.ContractService;
import com.example.service.contractdetail.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contractdetail")
public class ContractDetailController {

    @Autowired
    private ContractDetailService contractDetailService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private AttachServiceService attachServiceService;

    @GetMapping("")
    public String getContractDetailPage(Model model, @PageableDefault(size = 4) Pageable pageable) {
        model.addAttribute("contractDetailList", contractDetailService.findAll(pageable));
        return "contract_detail_list";
    }

    @GetMapping("/create")
    public String showContractDetailForm(@RequestParam(name = "idContract") Integer idContract, Model model) {
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("idContract", idContract);
        model.addAttribute("contract", this.contractService.findById(idContract));
        model.addAttribute("listAttachService", this.attachServiceService.findAll());
        return "contractDetail/create";
    }
    @PostMapping("/save")
    public String createContractDetail(@ModelAttribute(name = "contractDetail") ContractDetail contractDetail,
                                           @RequestParam(name = "idContract") Integer idContract,
                                           RedirectAttributes redirectAttributes) {
        Contract contract = contractService.findById(idContract);
        contractDetail.setContract(contract);
        this.contractDetailService.save(contractDetail);
        this.contractService.save(contract);

        redirectAttributes.addFlashAttribute("message", "Create Attach Service Successfully !");
        return "redirect:/contractdetail/";
    }

    @GetMapping("/view")
    public String getViewDetail(@RequestParam(name = "idContract") Integer idContract, Model model) {
        model.addAttribute("idContract", idContract);
        Contract contract = this.contractService.findById(idContract);
        model.addAttribute("contract", contractService.findById(idContract));
        model.addAttribute("contractDetailList",contractDetailService.findAllByContract(contract));
        return "contract/view";
    }


}
