package com.gdgbbsr.spectra.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class Message {
    private MessageType type;
    private String content;
    private String username;

    public enum MessageType {
        MESSAGE,
        JOIN,
        LEAVE
    }

}
