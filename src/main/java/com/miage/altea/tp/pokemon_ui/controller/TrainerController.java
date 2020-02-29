package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrainerController {
    @Autowired
    TrainerService trainerService;

    public void setPokemonTypeService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/trainers")
    public ModelAndView trainer() {
        var modelAndView = new ModelAndView("trainers");
        modelAndView.addObject("trainers", trainerService.getAllTrainers());
        return modelAndView;
    }

    @GetMapping(value="/trainers/{name}")
    public ModelAndView trainerByName(@PathVariable String name) {
        var modelAndView = new ModelAndView("trainer");
        modelAndView.addObject("trainer", trainerService.getTrainerByName(name));
        return modelAndView;

    }
}
