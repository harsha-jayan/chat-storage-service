package com.axi.org.chat_service.repository;

import com.axi.org.chat_service.data.ChatSession;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatSessionRepository extends MongoRepository<ChatSession, String> {
}
