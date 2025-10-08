package com.axi.org.chat_service.controller;

import com.axi.org.chat_service.data.ChatSession;
import com.axi.org.chat_service.delegators.SessionService;
import com.axi.org.chat_service.dto.CreateSessionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public String sayHello() {
        return "Hello from Chat Storage Service!!";
    }

    @PostMapping
    public ResponseEntity<ChatSession> createSession(@RequestBody CreateSessionRequest req){

        ChatSession s = sessionService.createSession(req.getUserId(), req.getTitle());
        //Improvement : Do Not pass the entire data here, create a builder and send ResponseDto
        return ResponseEntity.status(HttpStatus.CREATED).body(s);

    }
}
