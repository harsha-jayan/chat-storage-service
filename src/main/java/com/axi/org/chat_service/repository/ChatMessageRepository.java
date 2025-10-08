package com.axi.org.chat_service.repository;

import com.axi.org.chat_service.data.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
}
