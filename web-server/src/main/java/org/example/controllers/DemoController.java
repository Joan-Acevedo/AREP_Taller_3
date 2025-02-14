package org.example.controllers;

import org.example.framework.GetMapping;
import org.example.framework.RequestParam;
import org.example.framework.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {

    @GetMapping("/api/suma")
    public Map<String, Object> suma(@RequestParam("a") String a, @RequestParam("b") String b) {
        int resultado = Integer.parseInt(a) + Integer.parseInt(b);
        Map<String, Object> response = new HashMap<>();
        response.put("resultado", resultado);
        return response;
    }
}
