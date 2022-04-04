package com.case_study.controller;

import com.case_study.model.*;
import com.case_study.repository.position.PositionRepository;
import com.case_study.service.employee.division.DivisionService;
import com.case_study.service.employee.EmployeeService;
import com.case_study.service.employee.education_degree.EducationDegreeService;
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
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private EducationDegreeService educationDegreeService;
    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("/employee")
    public ModelAndView getCustomerList(@PageableDefault(size = 5) Pageable pageable, @RequestParam("search") Optional<String> search, Model model){
        Page<Employee> employees;
        if (search.isPresent()){
            employees = employeeService.findByName(search.get(), pageable);
            model.addAttribute("search", search.get());
        } else {
            employees = employeeService.findAll(pageable);
        }
        return new ModelAndView("/employee/list", "employees", employees);
    }

    @GetMapping("/create-employee")
    public ModelAndView showCreateForm(Model model){
        List<Division> divisions=   divisionService.findAll();
        model.addAttribute("divisions", divisions);
        List<EducationDegree> educationDegrees=   educationDegreeService.findAll();
        model.addAttribute("educationDegrees", educationDegrees);
        List<Position> positions=   positionRepository.findAll();
        model.addAttribute("positions", positions);
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public String saveCustomer(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes){
        employeeService.saveEmployee(employee);
//        ModelAndView modelAndView = new ModelAndView("/create");
//        modelAndView.addObject("blog", new Blog());
//        modelAndView.addObject("message", "New Blog created successfully");
        redirectAttributes.addFlashAttribute("message", "New employee Created Successfully");
        return "redirect:/employee";
    }
    @GetMapping("/edit-employee/{id}")
    public ModelAndView showEditForm(@PathVariable Long id, Model model){
        Employee employee = employeeService.findEmployeeById(id);
        List<Division> divisions=   divisionService.findAll();
        model.addAttribute("divisions", divisions);
        List<EducationDegree> educationDegrees=   educationDegreeService.findAll();
        model.addAttribute("educationDegrees", educationDegrees);
        List<Position> positions=   positionRepository.findAll();
        model.addAttribute("positions", positions);
        if(employee!=null){
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error_404");
            return modelAndView;
        }
    }

    @PostMapping("/edit_employee")
    public String updateEmployee(@ModelAttribute ("employee") Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute("message", "Employee updated successfully");
        return "redirect:/employee";
    }

    @GetMapping("/delete-employee/{id}")
    public String deleteCustomer(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
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

    //    @PostMapping("/delete-customer")
//    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
//        customerService.deleteCustomer(customer.getCustomerId());
//        return "redirect:/customer";
//    }
}
