package com.axi.org.chat_service.repository;

import com.axi.org.chat_service.data.UserSession;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserSessionRepository extends MongoRepository<UserSession, Integer> {
}
