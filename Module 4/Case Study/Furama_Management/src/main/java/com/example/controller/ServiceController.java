package com.example.controller;

import com.example.model.service.Service;
import com.example.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;


    @GetMapping("")
    public String getSerivcePage(Model model) {
        model.addAttribute("serviceList", serviceService.findAll());
        return "list_service";
    }

    @GetMapping("/create")
    public String getCreateService(Model model) {
        model.addAttribute("service", new Service());
        return "service/create";
    }

    @PostMapping("/save")
    public String createService(@Validated Service service, BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("serviceList", serviceService.findAll());
            return "service/create";
        }
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("message", "Create Successfully !");
        return "list_service";
    }
}
