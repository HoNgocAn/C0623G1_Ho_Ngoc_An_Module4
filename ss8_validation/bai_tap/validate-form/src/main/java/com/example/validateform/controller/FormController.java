package com.example.validateform.controller;

import com.example.validateform.dto.FormDTO;
import com.example.validateform.model.Form;
import com.example.validateform.service.IFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class FormController {
    @Autowired
    private IFormService formService;

    @GetMapping("/form")
    public ModelAndView showForm() {
        return new  ModelAndView("/index", "form" , new FormDTO());
    }

    @PostMapping("/validateForm")
    public ModelAndView createFrom(@Valid @ModelAttribute ("form") FormDTO formDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ModelAndView("/index","form", formDTO);
        } else {
            Form form = new Form();
            BeanUtils.copyProperties(formDTO,form);
            formService.save(form);
            return new ModelAndView("/result","form",form);
        }
    }
}
