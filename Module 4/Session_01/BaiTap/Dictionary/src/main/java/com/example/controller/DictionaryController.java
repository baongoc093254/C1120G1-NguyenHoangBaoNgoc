package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class DictionaryController {

    @GetMapping("")
    public String index() {
        return "index";
    }

    @PostMapping ("/dictionary")
    public String result(@RequestParam(name = "key") String key1, Model model) {
        Map<String, String> map = new TreeMap<>();
        map.put("love","Sang Bong");
        map.put("table","Cai Ban");
        map.put("ball","qua bong");
        map.put("pen","cai but");

        model.addAttribute("result", map.getOrDefault(key1, "Not found"));

        return "translate";
    }

}
