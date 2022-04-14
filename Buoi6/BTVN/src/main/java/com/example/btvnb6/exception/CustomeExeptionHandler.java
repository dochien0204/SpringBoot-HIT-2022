package com.example.btvnb6.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomeExeptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public  ErrorRespone handlerNotFoundExeption(NotFoundException ex, WebRequest rq){
        return new ErrorRespone(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(DuplicateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorRespone handleDuplicateException(DuplicateException ex, WebRequest rq)
    {
        return new ErrorRespone(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}
