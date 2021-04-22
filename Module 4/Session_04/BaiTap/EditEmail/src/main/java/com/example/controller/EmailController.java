package com.example.controller;

import com.example.model.Email;
import com.example.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {
    @Autowired
    EmailService emailService;

    @GetMapping("/")
    public ModelAndView getHome(Model model) {
        List<String> languageList = emailService.getLanguageList();
        List<Integer> pageSizeList = emailService.getPageSizeList();
        model.addAttribute("languageList",languageList);
        model.addAttribute("pageSizeList",pageSizeList);
        return new ModelAndView("index","email",new Email());
    }

    @PostMapping("/create")
    public ModelAndView createEmail(@ModelAttribute Email email, Model model) {
        List<String> languageList = emailService.getLanguageList();
        List<Integer> pageSizeList = emailService.getPageSizeList();
        model.addAttribute("languageList",languageList);
        model.addAttribute("pageSizeList",pageSizeList);
        return new ModelAndView("view","email",email);

    }




}
