package com.example.manageruniversity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExecption extends RuntimeException {
    public UserNotFoundExecption(String nameClass, String field, String value) {
        super(String.format("Not found %s have % with value is %s", nameClass, field, value));
    }
}
