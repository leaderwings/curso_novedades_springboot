package com.ejercicio1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("/home")
public class HomeController {
    String menuNavegacion = """
        <nav>
            <a href="/home">Home</a> |
            <a href="/home/saludo">Saludo</a> |
            <a href="/form">Formulario</a> |
            <a href="/time">Hora actual</a> |
            <a href="/env">Entorno</a> |
            <a href="/math/sumar?a=5&b=3">Sumar</a> |
            <a href="/text">Texto</a>
        </nav>
        <hr/>
    """;

    @GetMapping
    public String home(){
        return """
            %s
            <h3>Home</h3>
            <a href="/home">Home</a><br/>
            <a href="/home/saludo">Saludo</a><br/>
            <a href="/form">Formulario</a><br/>
            <a href="/time">Hora actual</a><br/>
            <a href="/env">Entorno</a><br/>
            <a href="/math/sumar?a=5&b=3">Sumar</a><br/>
            <a href="/text">Texto</a>
        """.formatted(menuNavegacion);
    }

    @GetMapping("/saludo")
    public String showFormSaludo(){
        return """
            %s
            <h3>Formulario de contacto</h3>
            <form action="/home/saludo/submit" method="post">
                Nombre: <input type="text" id="name" name="name"/><br/><br/>
                Email: <input type="text" id="email" name="email"/><br/><br/>
                <button type="submit">Enviar</button>
            </form>
        """.formatted(menuNavegacion);
    }

    @PostMapping("/saludo/submit")
    public String handleSubmit(@RequestParam(name = "name", required=false) String name, 
                @RequestParam(name = "email", required=false) String email){
        if (name == null || name.isBlank()){
            return """
                %s
                <h3>Error: El nombre es obligatorio.</h3>
                <a href="/form">Volver al formulario</a>
            """.formatted(menuNavegacion);
        }

        ZonedDateTime ahora = ZonedDateTime.now();
        String formato = "yyyy-MM-dd HH:mm:ss z";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);

        String ahoraFormateada = ahora.format(formateador);
        String saludo;

        if (ahora.getHour() < 12) {
            saludo = "Buenos días";
        } else if (ahora.getHour() < 20) {
            saludo = "Buenas tardes";
        } else {
            saludo = "Buenas noches";
        }

        String contrasenhaSegura = generarContrasenhaSegura();
        
        return """
            %s
            <h3>Hola %s </h3>
            <p>Recibimos su direccion de correo %s</p>
            <p>Su contraseña segura es %s</p>
            <p>%s, son las %s</p>
            """.formatted(menuNavegacion, escapeHtml(name), escapeHtml(email), contrasenhaSegura, saludo, ahoraFormateada);
    }

    private String escapeHtml(String input){
        if (input == null) return null;
        return input.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&apos;");
    }

    private String generarContrasenhaSegura() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+=<>?";
        SecureRandom random = new SecureRandom();
        StringBuilder contrasenha = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            int indice = random.nextInt(caracteres.length());
            contrasenha.append(caracteres.charAt(indice));
        }

        return contrasenha.toString();
    }





            
}
