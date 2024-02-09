package com.groupeisi.crudetudiant.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception e, Model model) {
        // Ajoutez des informations spécifiques à l'erreur au modèle si nécessaire
        model.addAttribute("error", e.getMessage());
        return "error"; // Créez une page d'erreur personnalisée (error.html) dans le dossier des templates
    }
}

