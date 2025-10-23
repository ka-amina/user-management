package org.example.controller;


import org.example.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    private final DatabaseService databaseService;

    @Autowired
    public TestController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/db-test")
    public String testDatabase() {
        return databaseService.testConnection();
    }
}