package com.example.demo.controller;

import com.example.demo.model.SmartPhone;
import com.example.demo.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SmartPhoneController {

    @Autowired
    private SmartPhoneService smartPhoneService;

    @GetMapping("/")
    public String getHomePage(Model model, @PageableDefault(size = 4, sort = "price") Pageable pageable) {
        model.addAttribute("listPhone", smartPhoneService.findAll(pageable));
        return "index";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("phone", new SmartPhone());
        return "create";
    }
    @PostMapping("/create")
    public String createSmartPhone(@ModelAttribute SmartPhone smartPhone, RedirectAttributes redirectAttributes) {
        smartPhoneService.save(smartPhone);
        redirectAttributes.addFlashAttribute("message", "Create Successfully !");
        return "redirect:/";
    }

    @GetMapping("/smartphone/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        System.out.println(id);
        model.addAttribute("smartphone", smartPhoneService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editSmartPhone(@ModelAttribute SmartPhone smartPhone, RedirectAttributes redirectAttributes) {
        smartPhoneService.update(smartPhone);
        redirectAttributes.addFlashAttribute("message", "Edit successfully !");
        return "redirect:/";
    }
}
