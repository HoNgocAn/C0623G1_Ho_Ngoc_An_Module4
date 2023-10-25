package com.example.validatesong.controller;


import com.example.validatesong.model.Song;
import com.example.validatesong.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping
    public ModelAndView showHome(Model model){
        return new ModelAndView("index","song",songService.findAllSong());
    }

    @GetMapping("/song/add")
    public ModelAndView showFormAddSong(){
        return new ModelAndView("add","song",new Song());
    }

    @PostMapping("/song/add")
    public ModelAndView saveSong(@Valid @ModelAttribute Song song, BindingResult bindingResult){
        ModelAndView modelAndView;
        if(bindingResult.hasErrors()){
            modelAndView = new ModelAndView("/add");
            return modelAndView;
        }
        songService.addSong(song);
        return new ModelAndView("redirect:/");
    }
    @GetMapping("/song/{id}/edit")
    public ModelAndView showFormEditSong(@PathVariable Integer id){
        Song song = songService.findById(id);
        return new ModelAndView("edit","song", song);
    }

    @PostMapping("/song/{id}/edit")
    public ModelAndView updateSong(@Valid @ModelAttribute Song song ,@PathVariable Integer id, BindingResult bindingResult){
        ModelAndView modelAndView;
        if(bindingResult.hasErrors()){
            modelAndView = new ModelAndView("/edit");
            return modelAndView;
        }
        songService.editSong(id, song);
        return new ModelAndView("redirect:/","song",song);
    }
}
