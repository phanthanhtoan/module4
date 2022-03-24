package com.ung_dung_blog2.controller;

import com.ung_dung_blog2.model.Blog;
import com.ung_dung_blog2.model.Category;
import com.ung_dung_blog2.service.blog.BlogService;
import com.ung_dung_blog2.service.category.CategoryService;
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
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ModelAndView getBlogList(@PageableDefault(size = 5) Pageable pageable,@RequestParam("search") Optional<String> search, Model model){
       Page<Blog> blogs;
        if (search.isPresent()){
            blogs = blogService.findByName(search.get(), pageable);
            model.addAttribute("search", search.get());
        } else {
            blogs = blogService.findAll(pageable);
        }
        return new ModelAndView("list", "blogs", blogs);
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm(Model model){
        List<Category> categories=   categoryService.findAll();
        model.addAttribute("categories", categories);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public String saveCustomer(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.saveBlog(blog);
//        ModelAndView modelAndView = new ModelAndView("/create");
//        modelAndView.addObject("blog", new Blog());
//        modelAndView.addObject("message", "New Blog created successfully");
        redirectAttributes.addFlashAttribute("message", "New Blog Created Successfully");
        return "redirect:/";
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Blog blog= blogService.findBlogById(id);
        if(blog!=null){
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error_404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute ("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.saveBlog(blog);
//        ModelAndView modelAndView = new ModelAndView("/edit");
//        modelAndView.addObject("blog", blog);
        redirectAttributes.addFlashAttribute("message", "Blog updated successfully");
        return "redirect:/";
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Blog blog = blogService.findBlogById(id);
        if (blog!= null){
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error_404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String deleteCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.deleteBlog(blog.getId());
        return "redirect:/";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView showViewBlog(@PathVariable Long id){
        Blog blog = blogService.findBlogById(id);
        if (blog!= null){
            ModelAndView modelAndView = new ModelAndView("/view");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error_404");
            return modelAndView;
        }
    }
}
