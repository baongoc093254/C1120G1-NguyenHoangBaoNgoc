package com.example.phonenumber.controller;

import com.example.phonenumber.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhoneNumberController {

    @GetMapping("/")
    public ModelAndView getForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("number",new PhoneNumber());
        return modelAndView;
    }

    @PostMapping("/validation")
    public ModelAndView checkValidation(@Validated @ModelAttribute("number") PhoneNumber phoneNumber, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("result");
        return modelAndView;

    }
}
