package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.tp.pokemon_ui.pokemonTypes.service.PokemonTypeService;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Pokemon;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;
import com.miage.altea.tp.pokemon_ui.trainers.service.TrainerService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private PokemonTypeService pokemonTypeService;

    @GetMapping
    ModelAndView myProfil() {
        String currentPrincipal = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        Trainer currentUser = trainerService.getTrainerByName(currentPrincipal);
        List<PokemonType> pokemons = currentUser.getTeam().stream()
                .map((Pokemon p) -> pokemonTypeService.getPokemonType(p.getPokemonTypeId()))
                .collect(Collectors.toList());
        Map<String, Object> map = new HashMap<>();
        map.put("user", currentUser);
        map.put("pokemons", pokemons);
        return new ModelAndView("profil", map);
    }
}