package com.axi.org.chat_service.controller;

import com.axi.org.chat_service.delegators.UserSessionService;
import com.axi.org.chat_service.dto.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class SessionController {

    @Autowired
    UserSessionService userSessionService;

    @GetMapping
    public String sayHello() {
        return "Hello from Chat Storage Service!!";
    }

    @PostMapping(value = "/createSession")
    public String saveSession(@RequestBody Session userSession ){

        return "Suceess";
    }
}
