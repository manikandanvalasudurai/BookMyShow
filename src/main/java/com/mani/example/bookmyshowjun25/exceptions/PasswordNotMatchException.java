package com.mani.example.bookmyshowjun25.exceptions;

import org.aspectj.bridge.IMessage;

public class PasswordNotMatchException extends Exception{
    public PasswordNotMatchException(String message) {
        super(message);
    }
}
