package org.example.controllers;

import org.example.framework.GetMapping;
import org.example.framework.RestController;
import org.example.framework.RequestParam;
import org.example.HttpServer.Request;
import org.example.HttpServer.Response;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "Mundo") String name) {
        return "Hola, " + name + "!";
    }


    @GetMapping("/pi")
    public String getPi(Request req, Response res) {
        return String.valueOf(Math.PI);
    }
}
