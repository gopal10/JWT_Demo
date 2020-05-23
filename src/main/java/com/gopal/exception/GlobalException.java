package com.gopal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException{
	
	@ExceptionHandler(value = UserNotAvailable.class)
    public ResponseEntity<String> exceptionhandler(UserNotAvailable e) {
        return new ResponseEntity<>("erorr exception occured in Global " + e.getString(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = UserAlreadyPresent.class)
    public ResponseEntity<String> exceptionhandler(UserAlreadyPresent e) {
        return new ResponseEntity<>("erorr exception occured in Global " + e.getString(), HttpStatus.CONFLICT);
    }

}
