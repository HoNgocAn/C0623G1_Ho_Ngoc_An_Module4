package com.example.customersexception.controller;

import com.example.customersexception.exception.DuplicateEmailException;
import com.example.customersexception.model.Customer;
import com.example.customersexception.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ModelAndView showHome(){
        return new ModelAndView("index", "customer", customerService.findAllCustomer());
    }
    @GetMapping("/add")
    public ModelAndView showFormAddCustomer(){
        return new ModelAndView("add","customer",new Customer());
    }

    @PostMapping("/add")
    public String saveCustomer(@ModelAttribute Customer customer) throws DuplicateEmailException{
            customerService.createCustomer(customer);
            return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String deleteBlog(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return "redirect:/customer";
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("/inputs-not-acceptable");
    }
}
