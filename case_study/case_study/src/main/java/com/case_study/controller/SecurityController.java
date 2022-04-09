package com.case_study.controller;

import com.case_study.dto.UserDto;
import com.case_study.model.Role;
import com.case_study.model.User;
import com.case_study.service.user_role.RoleService;
import com.case_study.service.user_role.UserService;
import com.case_study.ultil.EncrypPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;


@Controller
public class SecurityController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;


    @GetMapping("/login")
    public String getLoginPage(Model model){
        return "home/login";
    }


    @GetMapping("/register")
    public ModelAndView getRegisterPage(){
        return new ModelAndView("home/register","registerUser",new UserDto());
    }
    @PostMapping("/register")
    public String registerUser(@Validated @ModelAttribute("registerUser") UserDto registerUser, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "home/register";
        }else {
            User user = new User();
            user.setUsername(registerUser.getUserName());
//            user.setUsername(registerUser.getUserName());
            user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils(registerUser.getPassword()));
            Role roleEntity = roleService.findByRoleName("ROLE_MEMBER");
            Set<Role> listRoles = new HashSet<>();
            listRoles.add(roleEntity);
            user.setRoles(listRoles);
            userService.saveUser(user);
            return "redirect:home/login";
        }
    }

    @GetMapping("/403")
    public String getPage403(){
        return "home/403";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            Cookie cookie = new Cookie("remember-me", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "redirect:/";
    }
}
