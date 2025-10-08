package com.axi.org.chat_service.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Builder
@Document(collection = "user_session")
public class ChatSession {

    @Id
    private String id;

    @Indexed
    private String userId;

    private String title;

    private boolean favorite;

    private Instant createdAt;
    private Instant updatedAt;
}
