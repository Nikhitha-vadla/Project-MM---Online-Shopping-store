package com.massmutual.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.massmutual.demo.exceptions.AddressNotFoundException;
import com.massmutual.demo.exceptions.AppException;
import com.massmutual.demo.exceptions.DuplicateRecordException;
import com.massmutual.demo.exceptions.NoRecordFoundException;
import com.massmutual.demo.model.ErrorResponse;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AddressNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleAddressNotFoundException(AddressNotFoundException ex, WebRequest request) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoRecordFoundException.class)
    public final ResponseEntity handleNoRecordFoundException(NoRecordFoundException ex, WebRequest request) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateRecordException.class)
    public final ResponseEntity handleNoRecordFoundException(DuplicateRecordException ex, WebRequest request) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AppException.class)
    public final ResponseEntity<AppException> handleAppException(AppException ex, WebRequest request){
        return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

}