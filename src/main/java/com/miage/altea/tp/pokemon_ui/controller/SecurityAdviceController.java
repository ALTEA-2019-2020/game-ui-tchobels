package com.miage.altea.tp.pokemon_ui.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class SecurityAdviceController {

    @ModelAttribute(value = "user")
    Object principal(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
