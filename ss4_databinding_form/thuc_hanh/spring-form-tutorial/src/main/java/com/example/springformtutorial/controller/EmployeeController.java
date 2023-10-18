package com.example.springformtutorial.controller;

import com.example.springformtutorial.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping()
public class EmployeeController {
    @RequestMapping( method = RequestMethod.GET)
    public String showForm(ModelMap modelMap){
        modelMap.addAttribute("employee", new Employee());
        return "create";
    }
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit (@ModelAttribute("employee") Employee employee, ModelMap modelMap){
        modelMap.addAttribute("id", employee.getId());
        modelMap.addAttribute("name", employee.getName());
        modelMap.addAttribute("contactNumber", employee.getContactNumber());
        return "info";
    }
}
