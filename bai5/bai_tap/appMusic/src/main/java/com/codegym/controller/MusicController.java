package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping("/musics")
    public ModelAndView listCustomers() {
        List<Music> musics = musicService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("musics", musics);
        return modelAndView;
    }

    @GetMapping("/create-music")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("music", new Music());
        return modelAndView;
    }

    @PostMapping("/create-music")
    public ModelAndView saveMusic(@ModelAttribute("music") Music music) {
        musicService.save(music);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("musics", musicService.findAll());
        modelAndView.addObject("message", "New Music created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-music/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Music music = musicService.findById(id);
        if (music != null) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("music", music);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @PostMapping("/edit-music")
    public ModelAndView updateCustomer(@ModelAttribute("music") Music music) {
        musicService.save(music);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("musics", musicService.findAll());
        modelAndView.addObject("message", "Music updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-music/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Music music = musicService.findById(id);
        if (music != null) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("music", music);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @PostMapping("/delete-music")
    public String deleteCustomer(@ModelAttribute("music") Music music, RedirectAttributes redirectAttributes) {
        musicService.remove(music.getId());
        redirectAttributes.addFlashAttribute("message", "Music updated successfully");
        return "redirect:musics";
    }
}
