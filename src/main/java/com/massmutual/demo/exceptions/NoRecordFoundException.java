package com.massmutual.demo.exceptions;

public class NoRecordFoundException extends RuntimeException {

    public NoRecordFoundException(String message) {
        super(message);
    }
}
