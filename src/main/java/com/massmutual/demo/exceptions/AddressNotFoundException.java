package com.massmutual.demo.exceptions;

public class AddressNotFoundException extends RuntimeException  {

    public AddressNotFoundException(String message) {
        super(message);
    }
}
