package com.home.accountsservice.exception;


import com.home.accountsservice.util.ServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = { AccountException.class })
    public ResponseEntity<Object> handleInvalidInputException(AccountException ex) {
        logger.error("Invalid Input Exception: ",ex.getMessage());
        return new ResponseEntity<Object>( ServiceUtil.prepareResponseBean ( ex.getMessage (),HttpStatus.BAD_REQUEST.value ()), HttpStatus.BAD_REQUEST);
    }
}
