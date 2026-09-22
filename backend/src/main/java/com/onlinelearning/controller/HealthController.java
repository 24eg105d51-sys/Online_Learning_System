package com.onlinelearning.controller;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api") public class HealthController {
 @GetMapping("/health") public String health(){return "Online Learning System API is running";}
}
