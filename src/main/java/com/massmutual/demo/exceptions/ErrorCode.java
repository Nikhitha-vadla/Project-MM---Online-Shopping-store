package com.massmutual.demo.exceptions;

import lombok.Data;

@Data
public class ErrorCode {

    private String message;

    private String code;

    public ErrorCode(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public ErrorCode(String message) {
        this.message = message;
    }
}
