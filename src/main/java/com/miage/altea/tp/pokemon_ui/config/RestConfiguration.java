package com.miage.altea.tp.pokemon_ui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class RestConfiguration {

    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Bean
    RestTemplate trainerApiRestTemplate() {
        RestTemplate t = new RestTemplate();
        List<ClientHttpRequestInterceptor> l = new ArrayList<>();
        l.add(new BasicAuthenticationInterceptor(username, password));
        t.setInterceptors(l);
        return t;
    }

    @Bean
    RestTemplate pokemonTypeApiRestTemplate() {
        RestTemplate t = new RestTemplate();
        t.setInterceptors(
                Collections.singletonList(
                        (httpRequest, bytes, clientHttpRequestExecution) -> {
                            HttpHeaders headers = httpRequest.getHeaders();
                            headers.setAcceptLanguageAsLocales(Collections.singletonList(LocaleContextHolder.getLocale()));
                            return clientHttpRequestExecution.execute(httpRequest, bytes);
                        })
        );
        return t;
    }

}