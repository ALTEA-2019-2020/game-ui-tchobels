package com.miage.altea.tp.pokemon_ui.trainers.service.impl;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.tp.pokemon_ui.pokemonTypes.service.PokemonTypeService;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Pokemon;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;
import com.miage.altea.tp.pokemon_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerServiceImpl implements TrainerService {

    private final String TRAINER_PATH = "/trainers/";

    private RestTemplate restTemplate;

    private String trainerServiceUrl;

    private PokemonTypeService pokemonTypeService;

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    void setPokemonTypeService(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }

    @Value("${trainer.service.url}")
    void setTrainerServiceUrl(String trainerServiceUrl) {
        this.trainerServiceUrl = trainerServiceUrl;
    }


    @Override
    public List<Trainer> getAllTrainers() {
        return Arrays.asList(restTemplate.getForObject(trainerServiceUrl + TRAINER_PATH, Trainer[].class));
    }

    @Override
    public Trainer getTrainerByName(String name) {
        return restTemplate.getForObject(this.trainerServiceUrl+"/trainers/"+name, Trainer.class);
    }
}
