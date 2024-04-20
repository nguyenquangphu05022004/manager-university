package com.example.manageruniversity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundIdException extends RuntimeException{
    public NotFoundIdException(String className, String fieldName, String value) {
        super(String.format("Not found: %s of class: %s with value: %s", fieldName, className, value));
    }
}
