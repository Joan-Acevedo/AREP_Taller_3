package org.example.controllers;

import org.example.framework.GetMapping;
import org.example.framework.RestController;
import org.example.framework.RequestParam;

@RestController
public class SaludoController {

    @GetMapping("/api/saludo")
    public String saludo(@RequestParam("name") String name) {
        return "Hola, " + name;
    }
}

