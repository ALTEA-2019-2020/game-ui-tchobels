package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.tp.pokemon_ui.pokemonTypes.service.PokemonTypeService;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class PokemonTypeController {

    PokemonTypeService pokemonTypeService;

    @Autowired
    PokemonTypeController(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }

    @GetMapping("/pokedex")
    public ModelAndView pokedex() {
        Map<String, List<PokemonType>> map = new HashMap<>();
        List<PokemonType> pokedex = pokemonTypeService.listPokemonsTypes();
        pokedex.sort(Comparator.comparingInt(PokemonType::getId));
        map.put("pokemonTypes", pokedex);
        return new ModelAndView("pokedex", map);
    }

}