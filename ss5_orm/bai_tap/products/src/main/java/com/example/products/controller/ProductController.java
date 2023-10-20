package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "index";
    }
    @GetMapping("/product/add")
    public ModelAndView showFormAddProduct(){
        return new ModelAndView("add","product",new Product());
    }

    @PostMapping("/product/add")
    public ModelAndView saveProduct(@ModelAttribute Product product){
        productService.addProduct(product);
        return new ModelAndView("redirect:/");
    }
}
