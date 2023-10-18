package com.example.products.controller;

import com.example.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public ModelAndView showHome(){
        return new ModelAndView("index","products",productService.showAllProduct());
    }

}
