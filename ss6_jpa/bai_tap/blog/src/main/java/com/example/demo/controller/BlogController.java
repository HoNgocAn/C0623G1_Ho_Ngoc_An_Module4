package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class BlogController {

    @Autowired
    private IBlogService blogService;
    @GetMapping
    public ModelAndView showHome(Model model){
        return new ModelAndView("index","blog",blogService.getAllBlog());
    }

    @GetMapping("/blog/{id}/view")
    public ModelAndView showViewBlog(@PathVariable int id){
        Blog blog = blogService.findById(id);
        return new ModelAndView("view","blog", blog);
    }
    @GetMapping("/blog/add")
    public ModelAndView showFormAddBlog(){
        return new ModelAndView("add","blog",new Blog());
    }

    @PostMapping("/blog/add")
    public ModelAndView saveBlog(@ModelAttribute Blog blog){
        blogService.createBlog(blog);
        return new ModelAndView("redirect:/");
    }
    @GetMapping("/blog/{id}/delete")
    public String deleteBlog(@PathVariable int id){
        blogService.deleteBlog(id);
        return "redirect:/";
    }
}
