package com.log.pp2.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IdNotFoundException extends RuntimeException{
    private final LocalDateTime timestamp;
    public IdNotFoundException(String message) {
        super(message);
        this.timestamp = LocalDateTime.now();
    }

    public String getTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter);
    }
}
