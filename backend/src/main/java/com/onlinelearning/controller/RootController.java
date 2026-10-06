package com.onlinelearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    @GetMapping("/")
    public String home() {
        return "Online Learning System Backend is running. Open http://localhost:5173 to use the website.";
    }
}
