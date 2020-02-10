package com.miage.altea.tp.pokemon_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @PostMapping(value = "/registerTrainer")
    ModelAndView registerNewTrainer(String trainerName){
        var model = new ModelAndView();
        model.setViewName("register");
        model.addObject("name", trainerName);
        return model;
    }
}
