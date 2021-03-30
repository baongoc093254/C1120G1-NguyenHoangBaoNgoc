package com.example.controller;

import com.example.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @GetMapping("")
    public String getHome() {
        return "index";
    }


    @PostMapping("/calculator")
    public String doCalculator(@RequestParam String firstNumber,
                               @RequestParam String secondNumber,
                               @RequestParam String operator,
                               Model model) throws Exception {
        if (secondNumber == "0" & operator == "/") {
            model.addAttribute("message", "Not division by 0 !");
            return "index";
        } else {
            float result = calculatorService.calculate(firstNumber, secondNumber, operator);
            model.addAttribute("result", result);


        }
        return "index";
    }
}
