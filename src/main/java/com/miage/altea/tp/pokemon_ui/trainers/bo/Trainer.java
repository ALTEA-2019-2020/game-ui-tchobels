package com.miage.altea.tp.pokemon_ui.trainers.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Trainer {
    private String name;
    private List<Pokemon> team;
}