package com.example.calculator.controller;


import com.example.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping
    public ModelAndView showHome() {
        return new ModelAndView("index");
    }

    @PostMapping
    public ModelAndView resultCalculator(@RequestParam(name = "numberA") int numberA,
                                   @RequestParam(name = "numberB") int numberB, char math) {
        try {
            return new ModelAndView("index", "result", calculatorService.calculator(numberA, numberB, math));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ModelAndView("index", "error", "Error");
        }
    }
}