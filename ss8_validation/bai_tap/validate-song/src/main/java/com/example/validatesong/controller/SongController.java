package com.example.validatesong.controller;


import com.example.validatesong.dto.SongDTO;
import com.example.validatesong.model.Song;
import com.example.validatesong.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ModelAndView showHome(Model model) {
        return new ModelAndView("index", "song", songService.findAllSong());
    }

    @GetMapping("/song/add")
    public ModelAndView showFormAddSong() {
        return new ModelAndView("add", "song", new SongDTO());
    }

    @PostMapping("/song/add")
    public ModelAndView saveSong(@Valid @ModelAttribute("song") SongDTO songDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("add", "song", songDTO);
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO, song);
            songService.addSong(song);
            return new ModelAndView("redirect:/");
        }
    }

    @GetMapping("/song/{id}/edit")
    public ModelAndView showFormEditSong(@PathVariable Integer id) {
        Song song = songService.findById(id);
        return new ModelAndView("edit", "song", song);
    }

    @PostMapping("/song/{id}/edit")
    public ModelAndView updateSong(@Valid @ModelAttribute("song") SongDTO songDTO, @PathVariable Integer id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("edit", "song", songDTO);
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO, song);
            songService.editSong(id,song);
            return new ModelAndView("redirect:/");
        }
    }
}
