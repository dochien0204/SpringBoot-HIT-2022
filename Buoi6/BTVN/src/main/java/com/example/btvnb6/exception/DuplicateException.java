package com.example.btvnb6.exception;


public class DuplicateException extends RuntimeException {
    public DuplicateException(String message){
        super((message));
    }
}
