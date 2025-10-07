package com.axi.org.chat_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class SessionController {

    @GetMapping
    public String sayHello() {
        return "Hello from Chat Storage Service!";
    }
}
