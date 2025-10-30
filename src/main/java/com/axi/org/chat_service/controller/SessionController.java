package com.axi.org.chat_service.controller;

import com.axi.org.chat_service.data.ChatSession;
import com.axi.org.chat_service.delegators.SessionService;
import com.axi.org.chat_service.dto.CreateSessionRequest;
import com.axi.org.chat_service.dto.CreateSessionResponse;
import com.axi.org.chat_service.dto.RenameSessionRequest;
import com.axi.org.chat_service.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }
    @PostMapping
    public ResponseEntity<CreateSessionResponse> createSession(@RequestBody CreateSessionRequest req){
        log.info("Create Session request received :::");
        CreateSessionResponse s = sessionService.createSession(req.getUserId(), req.getTitle());
        //Improvement : Do Not pass the entire data here, create a builder and send ResponseDto
        return ResponseEntity.status(HttpStatus.CREATED).body(s);

    }

    @PatchMapping("/{id}/favorite")
    public ResponseEntity<ChatSession> markFavorite(@PathVariable("id") String id) {

        ChatSession s = sessionService.setFavorite(id, true);
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }

    @PatchMapping("/{id}/rename")
    public ResponseEntity<ChatSession> renameSession(@PathVariable("id") String id, @Valid @RequestBody RenameSessionRequest req){

        ChatSession s = sessionService.renameSession(id, req.getTitle());
        return ResponseEntity.status(HttpStatus.OK).body(s);

    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> delete(@PathVariable("id") String id){
        sessionService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted Successfully");

    }
}
