package com.example.formregister.controller;

import com.example.formregister.model.User;
import com.example.formregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/")
    public String getList(Model model) {
        List<User> userList = this.userService.findAll();
        model.addAttribute("userList",userList);
        return "list";

    }
    @GetMapping("/create")
    public String getCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }
    @PostMapping("/save")
    public String checkValidate(@Validated User user, BindingResult bindingResult, Model model) {
        new User().validate(user,bindingResult);
        if (bindingResult.hasErrors()) {
             model.addAttribute("userList", userService.findAll());
            return "create";
        }
        userService.save(user);
        model.addAttribute("message", "Register successfully !");
        return "redirect:/";

    }
}
