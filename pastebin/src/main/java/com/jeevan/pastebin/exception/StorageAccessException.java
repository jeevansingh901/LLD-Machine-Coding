package com.jeevan.pastebin.exception;

public class StorageAccessException extends RuntimeException {

    public StorageAccessException(String message) {
        super(message);
    }
}