package com.ejercicio1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;

@Controller
@RequestMapping("/status")
public class CuatroStatusController {

    @GetMapping("/ok")
    public ResponseEntity<String> ok(){
        return ResponseEntity.ok("Respuesta OK - status 200");
    }

    @GetMapping("/created")
    public ResponseEntity<String> created(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Locations", "/status/ok");

        return new ResponseEntity<>("Recurso creado", headers, HttpStatus.CREATED);
    }

    @GetMapping("/redirect")
    public String redirect(){
        return "redirect:/hello";
    }

    @GetMapping("/notfound")
    public ResponseEntity<String> notFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Página no encontrada (ejemplo 404)");
    }
}