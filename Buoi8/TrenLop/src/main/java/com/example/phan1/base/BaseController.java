package com.example.phan1.base;


import com.example.phan1.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController<T> {
    public ResponseEntity<?> resSuccess(T data) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO<T>(HttpStatus.OK.value(), "Sucess", data)
        );
    }


    public ResponseEntity<?> resFailed() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "Error", "Failed")
        );
    }
}
