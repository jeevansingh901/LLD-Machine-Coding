package com.jeevan.pastebin.exception;

public class PasteNotFoundException extends RuntimeException {

    public PasteNotFoundException(String message) {
        super(message);
    }
}
