package com.codegym.controller;

import com.codegym.model.Email;
import com.codegym.service.EmailService;
import com.codegym.service.IEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class EmailController {
    IEmailService emailService = new EmailService();


    @GetMapping("/")
    public String show(Model model) {
        model.addAttribute("emails", new Email(1, "English", 20, true, "John"));
        return "edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("emails") Email email,Model model) {
        model.addAttribute(email);
        return "resuilt";
    }


}
