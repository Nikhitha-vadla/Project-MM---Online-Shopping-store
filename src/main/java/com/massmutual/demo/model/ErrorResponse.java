package com.massmutual.demo.model;

import lombok.Data;

@Data

public class ErrorResponse {

    private String code = null;
    private String message = null;
    private String rootCause = null;



    public ErrorResponse message(String message) {
        this.message = message;
        return this;
    }


}
