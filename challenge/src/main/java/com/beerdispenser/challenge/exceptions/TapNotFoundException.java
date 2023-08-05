package com.beerdispenser.challenge.exceptions;

public class TapNotFoundException extends RuntimeException{

    public TapNotFoundException(String msg){
        super(msg);
    }

    public TapNotFoundException(String msg, Exception exc){
        super(msg, exc);
    }
}
