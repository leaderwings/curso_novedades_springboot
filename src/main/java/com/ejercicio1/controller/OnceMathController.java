package com.ejercicio1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/math")
public class OnceMathController {

    @GetMapping("/sumar")
    public String sumar(@RequestParam double a, @RequestParam double b) {
        double resultado = a + b;
        return "<h2>Resultado " + a + " + " + b + " = " + resultado + "</h2>";
    }


}
