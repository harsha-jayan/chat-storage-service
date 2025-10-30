package com.axi.org.chat_service.repository;

import com.axi.org.chat_service.data.ChatSession;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChatSessionRepository extends MongoRepository<ChatSession, String> {
}
