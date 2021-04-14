package com.example.demo.controller;

import com.example.demo.model.Credential;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class BaseController {
    @Autowired
    MessageSource messageSource;
    @GetMapping("/login")
    public String login(@ModelAttribute("credential")Credential credential) {
        return "login";
    }
    @PostMapping("/login")
    public String dasboard(@ModelAttribute("credential") Credential credential, Model model) {
        User user = new User();
        user.setUserName(credential.getUsername());
        model.addAttribute("user",user);
        return "redirect:/dashboard";
    }

}
