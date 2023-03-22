package com.example.service.springbootrewards.exception;

import com.example.service.springbootrewards.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
//    private static Logger logger = LoggerFactory.getLogger(RewardsController.class);
    @ExceptionHandler(CustomerNotFountException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerCustomerNotFount(Exception ex) {
//        logger.error("age is not valid, should larger than 0");
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerTransactionNotFound(Exception ex) {
//        logger.error("age is not valid, should larger than 0");
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}