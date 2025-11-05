package com.ejercicio1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("/headers")
public class DiezHeaderController {

    @GetMapping
    public String mostrarHeaders(@RequestHeader("User-Agent") String navegador, @RequestHeader(value = "Accept-Language", required = false) String idioma) {

        return """  
                <h2>Información del navegador</h2>
                <p><b>User-Agent:</b> %s</p>
                <p><b>Idioma preferido:</b> %s</p>
                """.formatted(navegador, idioma != null ? idioma : "No especificado");


    }
}
