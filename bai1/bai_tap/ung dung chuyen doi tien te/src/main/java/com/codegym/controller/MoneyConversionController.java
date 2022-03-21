package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyConversionController {

    @GetMapping("/")
    public String show(){
        return "input";
    }

    @PostMapping("/convert")
    public String convert( @RequestParam double usd , Model model){
        double resuilt=usd*22000;
        model.addAttribute("usd",usd);
        model.addAttribute("resuilt",resuilt);
        return "index";

    }
}
