package com.axi.org.chat_service.delegators;

import com.axi.org.chat_service.data.ChatSession;
import com.axi.org.chat_service.dto.CreateSessionRequest;
import com.axi.org.chat_service.repository.ChatSessionRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class SessionService {

    private final ChatSessionRepository sessionRepository;

    public SessionService(ChatSessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public ChatSession createSession(String userId, String title){
        ChatSession session = ChatSession.builder()
                .userId(userId)
                .title((title == null || title.isBlank()) ? "New chat" : title)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .favorite(false)
                .delete(false)
                .build();
        return sessionRepository.save(session);

    }
}
