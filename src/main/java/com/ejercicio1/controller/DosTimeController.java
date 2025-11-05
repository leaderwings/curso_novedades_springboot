package com.ejercicio1.controller;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time")
public class DosTimeController {
    @GetMapping
    public String getTime(){
        ZonedDateTime ahora = ZonedDateTime.now();
        String formato = "yyyy-MM-dd HH:mm:ss z";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);

        String ahoraFormateada = ahora.format(formateador);

        return "Hora actual delservidor: " + ahoraFormateada;
    }
}
