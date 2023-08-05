package com.beerdispenser.challenge.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
    private String errorCode;
    private String description;


    public ErrorMessage(String errorCode, String description){
        this.description = description;
        this.errorCode = errorCode;
    }
}
