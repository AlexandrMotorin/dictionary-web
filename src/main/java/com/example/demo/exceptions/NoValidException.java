package com.example.demo.exceptions;

public class NoValidException extends RuntimeException {
    public NoValidException(String message) {
        super(message);
    }
}
