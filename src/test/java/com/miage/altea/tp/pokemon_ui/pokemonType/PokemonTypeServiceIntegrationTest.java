package com.miage.altea.tp.pokemon_ui.pokemonType;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.service.PokemonTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PokemonTypeServiceIntegrationTest {

    @Autowired
    PokemonTypeService service;

    @Qualifier("pokemonTypeApiRestTemplate")
    @Autowired
    RestTemplate restTemplate;

    @Test
    void serviceAndTemplateShouldNotBeNull(){
        assertNotNull(service);
        assertNotNull(restTemplate);
    }

}
