package com.miage.altea.tp.pokemon_ui.trainers.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pokemon {
    private int pokemonTypeId;
    private int level;
}