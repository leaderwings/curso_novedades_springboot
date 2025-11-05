package com.ejercicio1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/form")
public class CincoFormController {
    @GetMapping
    @ResponseBody
    public String showForm(){
        return "<html><body>"
        + "<h3>Formulario de contacto</h3>"
        + "<form action=\"/form/submit\" method=\"post\">"
        + "Nombre: <input type=\"text\" id=\"name\" name=\"name\"/><br/><br/>"
        + "Email: <input type=\"text\" id=\"email\" name=\"email\"/><br/><br/>"
        + "<button type=\"submit\">Enviar</button>"
        + "</form>"
        + "</body>"
        + "</html>";
    }

    @PostMapping("/submit")
    @ResponseBody
    public String handleSubmit(@RequestParam(name = "name", required=false) String name, 
                @RequestParam(name = "email", required=false) String email){
        if (name == null || name.isBlank()){
            return "<html><body>"
            + "<h3>Error: El nombre es obligatorio.</h3>"
            + "<a href=\"/form\">Volver al formulario</a>"
            + "</body></html>";
        }
        
        return "<html><body>"
        + "<h3>Gracias " + escapeHtml(name) + "</h3>"
        + "<p>Recibimos tu email: " + escapeHtml(email) + "</p>"
        + "<a href=\"/hello\">Volver</a>"
        + "</body></html>";
    }

    private String escapeHtml(String input){
        if (input == null) return null;
        return input.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&apos;");
    }
}
