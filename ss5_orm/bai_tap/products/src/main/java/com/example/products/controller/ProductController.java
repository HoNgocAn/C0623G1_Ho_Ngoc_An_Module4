package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/product/{id}/view")
    public ModelAndView showViewProduct(@PathVariable Integer id){
        Product product = productService.findProduct(id);
        return new ModelAndView("view","product", product);
    }
    @GetMapping("/product/{id}/delete")
    public String deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
