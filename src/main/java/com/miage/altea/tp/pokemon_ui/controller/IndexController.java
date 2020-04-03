package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.service.PokemonTypeService;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Pokemon;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;
import com.miage.altea.tp.pokemon_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class IndexController {
    private TrainerService trainerService;

    @Autowired
    private PokemonTypeService pokemonTypeService;

    @Autowired
    IndexController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/registerTrainer")
    public ModelAndView registerNewTrainer(String trainerName) {
        Map<String, String> map = new HashMap<>();
        map.put("name", trainerName);
        return new ModelAndView("register", map);
    }

    @GetMapping("/trainers")
    public ModelAndView allTrainers() {
        List<Trainer> trainers = Arrays.asList(trainerService.getAllTrainers());
        trainers.forEach(trainer ->
                trainer.setTeamType(trainer.getTeam().stream()
                        .map((Pokemon p) -> pokemonTypeService.getPokemonType(p.getPokemonTypeId()))
                        .collect(Collectors.toList()))
        );
        Map<String, Object> map = new HashMap<>();
        map.put("trainers", trainers);
        return new ModelAndView("trainers", map);
    }
}