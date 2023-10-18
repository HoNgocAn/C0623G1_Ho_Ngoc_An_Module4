package com.example.sandwich;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class SandwichController {
    @GetMapping
    public String showView() {
        return "index";
    }
    @PostMapping("/save")
    public ModelAndView save(@RequestParam String[] select){
        return new ModelAndView("save","spice",select);
    }
}
