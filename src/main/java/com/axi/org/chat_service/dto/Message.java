package com.axi.org.chat_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @JsonProperty
    private String content;
    @JsonProperty
    private String context;

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
