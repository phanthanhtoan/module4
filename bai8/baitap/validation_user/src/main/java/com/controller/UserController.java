package com.controller;

import com.model.Category;
import com.model.User;
import com.service.category.CategoryService;
import com.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ModelAndView getUserList(@PageableDefault(size = 5) Pageable pageable, @RequestParam("search") Optional<String> search, Model model){
        Page<User> users;
        if (search.isPresent()){
            users = userService.findByEmail(search.get(), pageable);
            model.addAttribute("search", search.get());
        } else {
            users = userService.findALl(pageable);
        }
        return new ModelAndView("list", "users", users);
    }

    @GetMapping("/create-user")
    public ModelAndView showCreateForm(Model model){
        List<Category> categories=   categoryService.findAll();
        model.addAttribute("categories", categories);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create-user")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes,  Model model){
//        new User().validate(phoneNumber, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("user", user);
            return "/create";
        }
        else {
            userService.saveUser(user);
            model.addAttribute("phoneNumber", user);
            redirectAttributes.addFlashAttribute("message", "New User Created Successfully");
            return "redirect:/";
        }
//        userService.saveUser(user);
////        ModelAndView modelAndView = new ModelAndView("/create");
////        modelAndView.addObject("blog", new Blog());
////        modelAndView.addObject("message", "New Blog created successfully");
//        redirectAttributes.addFlashAttribute("message", "New User Created Successfully");
//        return "redirect:/";
    }
}
