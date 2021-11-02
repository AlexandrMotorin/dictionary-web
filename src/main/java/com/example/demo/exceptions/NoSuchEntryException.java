package com.example.demo.exceptions;

public class NoSuchEntryException extends RuntimeException{
    public NoSuchEntryException(String message) {
        super(message);
    }
}
