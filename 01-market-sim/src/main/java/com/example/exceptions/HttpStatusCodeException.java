package com.example.exceptions;

public class HttpStatusCodeException extends RuntimeException {
    private int statusCode;

    public HttpStatusCodeException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
