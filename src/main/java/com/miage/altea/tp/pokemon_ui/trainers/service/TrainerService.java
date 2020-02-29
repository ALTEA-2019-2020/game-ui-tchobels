package com.miage.altea.tp.pokemon_ui.trainers.service;

import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;

import java.util.List;

public interface TrainerService {
    List<Trainer> getAllTrainers();
    Trainer getTrainerByName(String name);
}