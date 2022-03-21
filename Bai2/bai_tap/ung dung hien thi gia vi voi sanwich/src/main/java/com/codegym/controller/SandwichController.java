package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String chooseCondiments() {
        return "index";
    }
    @PostMapping("/save")
    public String output(@RequestParam String condiment , Model model){
        model.addAttribute("condiment",condiment);
        return "resuilt";
    }
}
