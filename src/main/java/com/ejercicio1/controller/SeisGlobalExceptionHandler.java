package com.ejercicio1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class SeisGlobalExceptionHandler {
    
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(NoHandlerFoundException ex) {
        return "<html><body>"
        + "<h2>Error 404 - No encontrado</h2>"
        + "<p>La ruta solicitada no existe</p>"
        + "<a href=\"/hello\">Ir al inicio</a>"
        + "</body></html>";
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlerException(Exception ex) {
        return "<html><body>"
        + "<h2>Error 500 - Error interno</h2>"
        + "<p>" + escapeHtml(ex.getMessage()) + "</p>"
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
