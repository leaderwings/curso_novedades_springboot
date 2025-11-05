package com.ejercicio1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

// env.getProperty("app.name")
// Properties.load("application.properties")
@RestController
@RequestMapping("/system")
public class NueveSystemController {
    @Value("${app.name: Aplicacion sin nombre}")
    private String appName;

    @RequestMapping("/app-name")
    public String getAppName() {
        return appName;
    }

    @RequestMapping
    public String getSystemInfo() {
        String javaVersion = System.getProperty("java.version");
        String os = System.getProperty("os.name");
        
        return String.format("""
                <h2>Información del sistema</h2>
                <p>App: %s</p>
                <p>Java: %s</p>
                <p>OS: %s</p>
                """, appName, javaVersion, os);
    }

}
