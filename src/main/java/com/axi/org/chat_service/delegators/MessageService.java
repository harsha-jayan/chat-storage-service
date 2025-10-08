package com.axi.org.chat_service.delegators;

import com.axi.org.chat_service.data.ChatMessage;
import com.axi.org.chat_service.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final ChatMessageRepository messageRepository;

    @Autowired
    public MessageService(ChatMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    public void addMessage(String sessionId, String sender, String content, String context) {
        ChatMessage msg = ChatMessage.builder()
                .sessionId(sessionId)
                .sender(sender)
                .content(content)
                .context(context)
                .build();
        messageRepository.save(msg);
    }
}
