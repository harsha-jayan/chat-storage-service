package com.axi.org.chat_service.controller;

import com.axi.org.chat_service.delegators.MessageService;
import com.axi.org.chat_service.delegators.SessionService;
import com.axi.org.chat_service.dto.CreateMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sessions/{sessionId}/messages")
@Validated
public class MessageController {

    private final MessageService messageService;
    private final SessionService sessionService;

    @Autowired
    public MessageController(MessageService messageService, SessionService sessionService) {
        this.messageService = messageService;
        this.sessionService = sessionService;
    }

    @PostMapping
    public ResponseEntity<String> addMessage(@PathVariable String sessionId, @RequestBody CreateMessageRequest request){
        //ensure session exists
        sessionService.getSession(sessionId).orElseThrow(() -> new IllegalArgumentException("session not found"));
        messageService.addMessage(sessionId, request.getSender(), request.getContent(), request.getContext());
        return ResponseEntity.status(HttpStatus.CREATED).body("Message Added Successfully");
    }
}
