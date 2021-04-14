package com.example.managementcustomer.controller;

import com.example.managementcustomer.model.Province;
import com.example.managementcustomer.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;
    @GetMapping("/provinces")
    public ModelAndView getListProvince() {
        Iterable<Province> provinceList = provinceService.findAll();
        return new ModelAndView("provinces", "provinceList", provinceList);

    }
    @GetMapping("/provinces/create")
    public ModelAndView getCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create_province");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }
    @PostMapping("/create-province")
    public String saveProvince(@ModelAttribute Province province, RedirectAttributes redirectAttributes){
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "Create Successfully !");
        return "provinces";

    }
    @GetMapping("/provinces/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Province province = provinceService.findById(id);
        return new ModelAndView("edit", "province", province);

    }

    @GetMapping("/delete/provinces")
    public String deleteProvinces(@RequestParam Integer id) {
        provinceService.remove(id);
        return "provinces";
    }
}

