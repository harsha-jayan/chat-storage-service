package com.axi.org.chat_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RenameSessionRequest {

    @NotBlank
    private String title;

}
