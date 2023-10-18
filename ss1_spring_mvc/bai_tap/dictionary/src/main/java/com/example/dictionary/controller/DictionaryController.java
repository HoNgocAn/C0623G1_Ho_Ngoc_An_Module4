package com.example.dictionary.controller;


import com.example.dictionary.repository.IDictionaryRepository;
import com.example.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping
    public ModelAndView showHome(){
        return new ModelAndView("index");
    }
    @GetMapping("/search")
    public ModelAndView showResult(String key){
        return new ModelAndView("index","result",dictionaryService.showResult(key));
    }
}
