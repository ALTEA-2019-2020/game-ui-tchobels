package com.miage.altea.tp.pokemon_ui.trainers.service;

import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;

public interface TrainerService {
    Trainer[] getAllTrainers();
    Trainer getTrainerByName(String name);
}