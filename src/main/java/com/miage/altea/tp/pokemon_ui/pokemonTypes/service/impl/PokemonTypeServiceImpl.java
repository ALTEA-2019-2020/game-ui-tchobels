package com.miage.altea.tp.pokemon_ui.pokemonTypes.service.impl;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.tp.pokemon_ui.pokemonTypes.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {
    @Autowired
    @Qualifier("pokemonTypeApiRestTemplate")
    RestTemplate pokemonTypeApiRestTemplate;

    private String pokemonServiceUrl = "http://localhost:8080";


    public List<PokemonType> listPokemonsTypes() {
        PokemonType[] pokemonTypes = pokemonTypeApiRestTemplate.getForObject("http://localhost:8080/pokemon-types/", PokemonType[].class);
        return pokemonTypes != null ? Arrays.asList(pokemonTypes) : new ArrayList<>();
    }

    @Override
    public PokemonType getPokemonType(int id) {
        return pokemonTypeApiRestTemplate.getForObject("http://localhost:8080/pokemon-types/{id}", PokemonType.class, id);
    }


    @Autowired
    public void setRestTemplate(@Qualifier("pokemonTypeApiRestTemplate") RestTemplate pokemonTypeApiRestTemplate) {
        this.pokemonTypeApiRestTemplate = pokemonTypeApiRestTemplate;
    }

    @Value("${pokemonType.service.url}")
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }
}
