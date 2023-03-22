package com.example.service.springbootrewards.exception;

public class CustomerNotFountException extends RuntimeException{
    private String errorMessage;
    public CustomerNotFountException() {
        super();
    }

    public CustomerNotFountException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
    public String getMessage() {
        return errorMessage;
    }
}
