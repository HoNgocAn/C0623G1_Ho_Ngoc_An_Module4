package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
    @GetMapping
    public ModelAndView showHome(Model model){
        return new ModelAndView("index","blog",blogService.getAllBlog());
    }

    @GetMapping("/blog/list")
    public ModelAndView showList(@PageableDefault(value = 2,sort = "timePost",direction = Sort.Direction.DESC) Pageable pageable) {
        return new ModelAndView("index","blog",blogService.getAllBlog(pageable));
    }

    @GetMapping("/blog/{id}/view")
    public ModelAndView showViewBlog(@PathVariable Integer id){
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
    public String deleteBlog(@PathVariable Integer id){
        blogService.deleteBlog(id);
        return "redirect:/";
    }
    @GetMapping("/blog/{id}/edit")
    public ModelAndView showFormEditBlog(@PathVariable Integer id){
        Blog blog = blogService.findById(id);
        return new ModelAndView("edit","blog", blog);
    }

    @PostMapping("/blog/{id}/edit")
    public ModelAndView updateBlog(@ModelAttribute Blog blog ,@PathVariable Integer id){
        blogService.updateBlog(id, blog);
        return new ModelAndView("redirect:/","blog", blog);
    }
}
