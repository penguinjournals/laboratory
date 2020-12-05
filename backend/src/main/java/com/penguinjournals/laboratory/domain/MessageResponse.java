package com.penguinjournals.laboratory.domain;

public class MessageResponse {
    private String message;

    public MessageResponse(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
