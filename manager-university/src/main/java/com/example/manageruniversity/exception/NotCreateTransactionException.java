package com.example.manageruniversity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CREATED)
public class NotCreateTransactionException extends RuntimeException{
    private String message;
    public NotCreateTransactionException(String message) {
        super(message);
    }
}
