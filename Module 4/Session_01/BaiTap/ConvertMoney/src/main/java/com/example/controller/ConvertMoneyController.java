package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.pkcs11.Secmod;

@Controller
public class ConvertMoneyController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @PostMapping("/usd")
    public String submit(@RequestParam String usd, @RequestParam String rate, Model model) {
        float result = Float.parseFloat(usd) * Float.parseFloat(rate);
        model.addAttribute("usd",usd);
        model.addAttribute("rate",rate);
        model.addAttribute("result", result);
        return "index";

    }

}
