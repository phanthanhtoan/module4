package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping("/")
    public String chooseCondiments() {
        return "index";
    }

    @PostMapping("/calculate")
    public String output(@RequestParam float num1, @RequestParam float num2,@RequestParam String caculator, Model model) {
        float resuilt=0;
        if(caculator.equals("add")){
            resuilt = num1 + num2;
        }else  if(caculator.equals("sub")){
            resuilt = num1 - num2;
        }else  if(caculator.equals("mul")){
            resuilt = num1 * num2;
        }else  if(caculator.equals("div")){
            resuilt = num1 / num2;
        }
        model.addAttribute("resuilt", resuilt);

        return "index";
    }
}
