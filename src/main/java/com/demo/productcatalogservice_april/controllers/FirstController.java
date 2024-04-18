package com.demo.productcatalogservice_april.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping
    public String helloWorld() {
        return "Welcome to My First Spring boot project";
    }
}
