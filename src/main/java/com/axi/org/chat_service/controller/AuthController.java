package com.axi.org.chat_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/auth")
@Slf4j
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestHeader("X-API-KEY") String header){
        log.info("Login attempt ::");
        return "Login Successful";
    }


}
