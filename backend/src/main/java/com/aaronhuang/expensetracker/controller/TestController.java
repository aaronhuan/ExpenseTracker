package com.aaronhuang.expensetracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @GetMapping
    public String home() {
        return "Expense Tracker API is running! For services login using /api/v1/users ";
    }
    
    @GetMapping("/health")
    public String health() {
        return "{\"status\": \"OK\", \"timestamp\": \"" + LocalDateTime.now() + "\"}";
    }    
}
