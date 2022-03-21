package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @GetMapping("/")
    public String show() {
        return "input";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam String inputText, Model model) {
        String resuilt = "";
        if (inputText.equals("house")) {
            resuilt = "Ngoi Nha";
        } else if (inputText.equals("flower")) {
            resuilt = "Bong Hoa";
        } else {
            resuilt = "unKnown";
        }
        model.addAttribute("resuilt", resuilt);
        model.addAttribute("inputText", inputText);
        return "index";

    }
}
