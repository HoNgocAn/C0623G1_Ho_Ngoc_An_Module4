package com.example.demo.controller;


import com.example.demo.service.IStudentService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping
    public String showList(Model model, ModelMap modelMap){
        model.addAttribute("studentName", "Nguyễn Văn D");
        modelMap.addAttribute("studentClass", "C0623G1");
        model.addAttribute("studentList", studentService.findAll());
        return "index";
    }
}
