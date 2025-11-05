package com.ejercicio1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/html")
public class OchoHtmlController {
    @GetMapping
    public String mensaje() {
        return """
            <html>
            <head>
            <title>Hola Spring Boot</title>
            </head>
            <body style="font-family:Arial; text-align:center; margin-top:50px;">
                <h1>Podés devolver directamente desde tu controller</h1>
            </body>
            </html>
        """;
    }

}
