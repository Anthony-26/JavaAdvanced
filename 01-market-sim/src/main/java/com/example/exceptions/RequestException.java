package com.example.exceptions;

public class RequestException extends RuntimeException {
    private int statusCode;

    public RequestException(String message) {
        super(message);
    }

    public RequestException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
