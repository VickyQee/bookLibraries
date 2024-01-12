package com.example.New_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@RestControllerAdvice
public class ExceptionHandling {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException exception) {

        return (exception.getLocalizedMessage() +" ### " + "error with service injection @Controller");

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgumentException(IllegalArgumentException exception){
        return exception.getLocalizedMessage();
    }
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IllegalStateException.class)
    public String illegalStateException (IllegalStateException exception){
        return exception.getLocalizedMessage() +" " + "no primary unique constructor found for interface";
}

}
