package com.ejercicio1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

record Mensaje(String texto, String autor) {}

@RestController
@RequestMapping("/text")
public class SieteTextController {
    
    @GetMapping
    public String mensaje() {
        Mensaje m = new Mensaje("Spring Boot sos el mejor", "Amparo");

        return "<h2>" + m.texto() + "</h2><p>Autor: " + m.autor() + "</p>";
    }

}

