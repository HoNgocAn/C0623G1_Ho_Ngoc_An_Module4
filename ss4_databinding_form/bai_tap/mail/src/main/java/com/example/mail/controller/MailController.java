package com.example.mail.controller;

import com.example.mail.model.Mail;
import com.example.mail.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailController {
    @Autowired
    private IMailService mailService;

    @GetMapping()
    public String showMail(Model model){
        model.addAttribute("mail", mailService.showMail());
        return "view";
    }
    @PostMapping("/save")
    public ModelAndView saveMail(@ModelAttribute Mail mail){
        mailService.updateMail(mail);
        return new ModelAndView("redirect: view");
    }
}
