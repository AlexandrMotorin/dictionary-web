package com.example.demo.controllers;

import com.example.demo.exceptions.EntryIncorrectData;
import com.example.demo.exceptions.NoSuchEntryException;
import com.example.demo.exceptions.NoValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DictionaryExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EntryIncorrectData> handleException(NoValidException e){

        EntryIncorrectData data = new EntryIncorrectData();
        data.setInfo(e.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<EntryIncorrectData> handleException(NoSuchEntryException e){

        EntryIncorrectData data = new EntryIncorrectData();
        data.setInfo(e.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}