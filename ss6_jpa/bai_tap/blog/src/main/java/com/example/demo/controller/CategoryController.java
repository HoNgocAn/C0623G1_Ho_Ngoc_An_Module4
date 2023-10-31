package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping("/list")
    public ModelAndView showListCategory(@PageableDefault(value = 2) Pageable pageable){
        return new ModelAndView("category-list","category",categoryService.findAllCategory(pageable));
    }

    @GetMapping("/add")
    public ModelAndView showFormAdd(){
        return new ModelAndView("add-category","category",new Category());
    }

    @PostMapping("/add")
    public String saveCategory(@ModelAttribute Category category){
        categoryService.createCategory(category);
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String viewDetailCategory(Model model, @PathVariable Integer id){
        model.addAttribute("category", categoryService.findCategoryById(id));
        model.addAttribute("blogs", blogService.getBlogByCategoryId(id));
        return "view-category";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable Integer id){
        return new ModelAndView("edit-category","category", categoryService.findCategoryById(id));
    }

    @PostMapping("/{id}/edit")
    public String updateCategory(@ModelAttribute Category category){
        categoryService.updateCategory(category);
        return "redirect:/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return "redirect:/list";
    }
}
