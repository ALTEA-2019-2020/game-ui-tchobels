package com.miage.altea.tp.pokemon_ui.trainers.service.impl;

import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;
import com.miage.altea.tp.pokemon_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrainerServiceImpl implements TrainerService {

    private RestTemplate restTemplate;

    private String trainerServiceUrl;

    @Autowired
    @Qualifier("trainerApiRestTemplate")
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Value("${trainer.service.url}")
    void setPokemonTypeServiceUrl(String trainerServiceUrl) {
        this.trainerServiceUrl = trainerServiceUrl;
    }

    @Override
    public Trainer getTrainerByName(String name) {
        return this.restTemplate.getForObject(trainerServiceUrl + "/trainers/" + name, Trainer.class);
    }

    @Override
    public Trainer[] getAllTrainers() {
        return this.restTemplate.getForObject(trainerServiceUrl + "/trainers/", Trainer[].class);
    }
}
