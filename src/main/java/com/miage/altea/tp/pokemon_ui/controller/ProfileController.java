package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.trainers.service.TrainerService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    private TrainerService trainerService;

    @Autowired
    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping(value = "/")
    public ModelAndView profil(){
        var modelAndView = new ModelAndView("profile");

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        modelAndView.addObject("trainerDetail", trainerService.getTrainerByName(principal.getUsername()));
        modelAndView.addObject("allTrainer", trainerService.getAllTrainers());
        return modelAndView;
    }
}