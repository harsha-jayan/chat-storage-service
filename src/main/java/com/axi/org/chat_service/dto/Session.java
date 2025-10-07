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
public class Session {
    @JsonProperty
    private String senderName;
    @JsonProperty
    private String mailId;
    @JsonProperty
    private Boolean isFavourite;
    @JsonProperty
    private Boolean delete;
    @JsonProperty
    private Message message;


    @Override
    public String toString() {
        return "Session{" +
                "senderName='" + senderName + '\'' +
                ", mailId='" + mailId + '\'' +
                ", isFavourite=" + isFavourite +
                ", delete=" + delete +
                ", message=" + message +
                '}';
    }
}
