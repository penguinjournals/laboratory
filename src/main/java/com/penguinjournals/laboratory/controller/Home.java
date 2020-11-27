package com.penguinjournals.laboratory.controller;

import com.penguinjournals.laboratory.domain.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @GetMapping("/")
    public Greeting home() {
        Greeting greeting = new Greeting();
        return greeting;
    }
}
