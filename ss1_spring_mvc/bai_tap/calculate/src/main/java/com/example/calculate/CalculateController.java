package com.example.calculate;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculateController {

    @GetMapping()
    public ModelAndView showView() {
        return new ModelAndView("index");
    }
    @GetMapping("/calculate")
    public ModelAndView convertMoneyUsdToVnd(float usd) {
        float vnd = usd*23000;
        return new ModelAndView("index", "vnd", vnd);
    }
}
