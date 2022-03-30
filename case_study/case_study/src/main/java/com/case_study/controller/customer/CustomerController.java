package com.case_study.controller.customer;

import com.case_study.model.Customer;
import com.case_study.model.CustomerType;
import com.case_study.service.customer.CustomerService;
import com.case_study.service.customer_type.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
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
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/customer")
    public ModelAndView getBlogList(@PageableDefault(size = 5) Pageable pageable,@RequestParam("search") Optional<String> search, Model model){
        Page<Customer> customers;
        if (search.isPresent()){
            customers = customerService.findByName(search.get(), pageable);
            model.addAttribute("search", search.get());
        } else {
            customers = customerService.findAll(pageable);
        }
        return new ModelAndView("/customer/list", "customers", customers);
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm(Model model){
        List<CustomerType> customerTypes=   customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypes);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes){
        customerService.saveCustomer(customer);
//        ModelAndView modelAndView = new ModelAndView("/create");
//        modelAndView.addObject("blog", new Blog());
//        modelAndView.addObject("message", "New Blog created successfully");
        redirectAttributes.addFlashAttribute("message", "New Customer Created Successfully");
        return "redirect:/customer";
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id, Model model){
        Customer customer= customerService.findCustomerById(id);
        List<CustomerType> customerTypes=   customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypes);
        if(customer!=null){
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error_404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute ("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.saveCustomer(customer);
//        ModelAndView modelAndView = new ModelAndView("/edit");
//        modelAndView.addObject("blog", blog);
        redirectAttributes.addFlashAttribute("message", "Customer updated successfully");
        return "redirect:/customer";
    }

//    @GetMapping("/delete-customer/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id){
//        Customer customer = customerService.findCustomerById(id);
//        if (customer!= null){
//            ModelAndView modelAndView = new ModelAndView("/customer/delete");
//            modelAndView.addObject("customer", customer);
//            return modelAndView;
//        }else {
//            ModelAndView modelAndView = new ModelAndView("/error_404");
//            return modelAndView;
//        }
//    }

    @RequestMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable Long id, @ModelAttribute("customer") Customer customer){
    customerService.findCustomerById(id);
    customerService.deleteCustomer(customer.getCustomerId());

        if (customer!= null){
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer);
            return "redirect:/customer";
        }else {
            ModelAndView modelAndView = new ModelAndView("/error_404");
            return "redirect:/customer";
        }
    }

//    @PostMapping("/delete-customer")
//    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
//        customerService.deleteCustomer(customer.getCustomerId());
//        return "redirect:/customer";
//    }
}
