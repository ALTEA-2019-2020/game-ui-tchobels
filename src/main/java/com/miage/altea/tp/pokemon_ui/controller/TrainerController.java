package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/trainers")
public class TrainerController {

    private TrainerService trainerService;

    @Autowired
    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping(value = "/")
    public ModelAndView trainers(){
        var modelAndView = new ModelAndView("trainers");
        modelAndView.addObject("allTrainer", trainerService.getAllTrainers());
        return modelAndView;
    }

    @GetMapping(value = "/{name}")
    public ModelAndView trainerName(@PathVariable String name){
        var modelAndView = new ModelAndView("trainerDetail");
        modelAndView.addObject("trainerDetail", trainerService.getTrainerByName(name));
        return modelAndView;
    }
}
