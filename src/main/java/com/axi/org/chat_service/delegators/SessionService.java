package com.axi.org.chat_service.delegators;

import com.axi.org.chat_service.data.ChatSession;
import com.axi.org.chat_service.dto.CreateSessionResponse;
import com.axi.org.chat_service.exception.ResourceNotFoundException;
import com.axi.org.chat_service.repository.ChatMessageRepository;
import com.axi.org.chat_service.repository.ChatSessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@Slf4j
public class SessionService {

    private final ChatSessionRepository sessionRepository;
    private final ChatMessageRepository messageRepository;

    public SessionService(ChatSessionRepository sessionRepository, ChatMessageRepository messageRepository) {
        this.sessionRepository = sessionRepository;
        this.messageRepository = messageRepository;
    }

    public CreateSessionResponse createSession(String userId, String title){

        title = (title == null || title.isBlank()) ? "New chat" : title;
        ChatSession session = ChatSession.builder()
                .userId(userId)
                .title(title)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .favorite(false)
                .build();

        ChatSession saved = sessionRepository.save(session);

        log.info("Session created with id {}", saved.getId());

        return CreateSessionResponse.builder()
                .userId(saved.getUserId())
                .title(saved.getTitle())
                .build();

    }

    public Optional<ChatSession> getSession(String sessionId) {
        return sessionRepository.findById(sessionId);
    }

    public ChatSession setFavorite(String sessionId, boolean favorite) throws ResourceNotFoundException{

        ChatSession s = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException("session not found"));

        s.setFavorite(favorite);
        s.setUpdatedAt(Instant.now());
        return sessionRepository.save(s);

    }

    public ChatSession renameSession(String sessionId, String title) {
        ChatSession s = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException("session not found"));

        s.setTitle(title);
        s.setUpdatedAt(Instant.now());

        return sessionRepository.save(s);
    }

    public void delete(String sessionId) {

        // delete messages first then session
        messageRepository.deleteBySessionId(sessionId);
        sessionRepository.deleteById(sessionId);
    }
}
