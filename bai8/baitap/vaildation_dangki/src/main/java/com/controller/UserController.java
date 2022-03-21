package com.controller;

import com.model.User;
import com.repository.CategoryUserRepository;
import com.service.categoryUser.CategoryUserService;
import com.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryUserService categoryUserService;
    @GetMapping("")
    public ModelAndView getBlogList(@PageableDefault(size = 5) Pageable pageable, @RequestParam("search") Optional<String> search, Model model){
        Page<User> users;
        if (search.isPresent()){
            users = userService.findByName(search.get(), pageable);
            model.addAttribute("search", search.get());
        } else {
            users = userService.findAll(pageable);
        }
        return new ModelAndView("list", "users", users);
    }

    @GetMapping("/create-user")
    public ModelAndView showCreateForm(Model model){
        List<CategoryUserRepository> categoryUsers=   categoryUserService.findAll();
        model.addAttribute("categoryUsers", categoryUsers);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create-user")
    public String saveCustomer(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes){
        userService.saveUser(user);
//        ModelAndView modelAndView = new ModelAndView("/create");
//        modelAndView.addObject("blog", new Blog());
//        modelAndView.addObject("message", "New Blog created successfully");
        redirectAttributes.addFlashAttribute("message", "New User Created Successfully");
        return "redirect:/";
    }

    @GetMapping("/edit-user/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        User user= userService.findUserById(id);
        if(user!=null){
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("user", user);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error_404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute ("user") User user, RedirectAttributes redirectAttributes) {
        userService.saveUser(user);
//        ModelAndView modelAndView = new ModelAndView("/edit");
//        modelAndView.addObject("blog", blog);
        redirectAttributes.addFlashAttribute("message", "User updated successfully");
        return "redirect:/";
    }

    @GetMapping("/delete-user/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        User user = userService.findUserById(id);
        if (user!= null){
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("user", user);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error_404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-user")
    public String deleteCustomer(@ModelAttribute("blog") User user) {
        userService.deleteUser(user.getId());
        return "redirect:/";
    }

    @GetMapping("/view-user/{id}")
    public ModelAndView showViewBlog(@PathVariable Long id){
        User user = userService.findUserById(id);
        if (user!= null){
            ModelAndView modelAndView = new ModelAndView("/view");
            modelAndView.addObject("user", user);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error_404");
            return modelAndView;
        }
    }
}
