package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/")
    public String hello() {
        return "<h1>Hello World!</h1><p>This is a fully automated deployment from Jenkins.</p>";
    }
}
