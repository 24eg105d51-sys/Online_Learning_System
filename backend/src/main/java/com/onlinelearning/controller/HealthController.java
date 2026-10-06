package com.onlinelearning.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HealthController {
    @GetMapping("/health")
    public String health() {
        return "Online Learning System API is running";
    }
    
    @GetMapping({"", "/"})
    public String apiHome() {
        return "Online Learning System Backend is running. Use http://localhost:5173 for the website.";
    }
}
