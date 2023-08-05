package com.beerdispenser.challenge.exceptions;

public class TapCreatedException extends RuntimeException{

    public TapCreatedException(String msg){
        super(msg);
    }

    public TapCreatedException(String msg, Exception exc){
        super(msg, exc);
    }
}
