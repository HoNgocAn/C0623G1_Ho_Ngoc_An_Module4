package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;


    @GetMapping
    public ModelAndView showHome(){
        return new ModelAndView("index","blog",blogService.findAllBlog());
    }

    @GetMapping("/blog/list")
    public ModelAndView showList(@PageableDefault(value = 2,sort = "timePost",direction = Sort.Direction.DESC) Pageable pageable) {
        return new ModelAndView("index","blog",blogService.findAllBlog(pageable));
    }

    @GetMapping("/blog/add")
    public ModelAndView showFormAdd(Model model){
        model.addAttribute("categoryList",categoryService.findAllCategory());
        return new ModelAndView("add","blog",new Blog());
    }

    @PostMapping("/blog/add")
    public String saveBlog(@ModelAttribute Blog blog){
        blogService.createBlog(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/blog/{id}/view")
    public ModelAndView viewDetailBlog(@PathVariable Integer id){
        return new ModelAndView("view","blog", blogService.findBlogById(id));
    }

    @GetMapping("/blog/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable Integer id, Model model){
        model.addAttribute("category",categoryService.findAllCategory());
        return new ModelAndView("edit","blog", blogService.findBlogById(id));
    }

    @PostMapping("/blog/{id}/edit")
    public String updateBlog(@ModelAttribute Blog blog){
        blogService.updateBlog(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/blog/{id}/delete")
    public String deleteBlog(@PathVariable Integer id){
        blogService.deleteBlog(id);
        return "redirect:/blog/list";
    }

}
