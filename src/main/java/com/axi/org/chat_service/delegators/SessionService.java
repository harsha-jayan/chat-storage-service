package com.axi.org.chat_service.delegators;

import com.axi.org.chat_service.data.ChatSession;
import com.axi.org.chat_service.repository.ChatMessageRepository;
import com.axi.org.chat_service.repository.ChatSessionRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class SessionService {

    private final ChatSessionRepository sessionRepository;
    private final ChatMessageRepository messageRepository;

    public SessionService(ChatSessionRepository sessionRepository, ChatMessageRepository messageRepository) {
        this.sessionRepository = sessionRepository;
        this.messageRepository = messageRepository;
    }

    public ChatSession createSession(String userId, String title){
        ChatSession session = ChatSession.builder()
                .userId(userId)
                .title((title == null || title.isBlank()) ? "New chat" : title)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .favorite(false)
                .build();
        return sessionRepository.save(session);

    }

    public Optional<ChatSession> getSession(String sessionId) {
        return sessionRepository.findById(sessionId);
    }

    public ChatSession setFavorite(String sessionId, boolean favorite) {

        ChatSession s = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("session not found"));

        s.setFavorite(favorite);
        s.setUpdatedAt(Instant.now());
        return sessionRepository.save(s);

    }

    public ChatSession renameSession(String sessionId, String title) {
        ChatSession s = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("session not found"));

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
