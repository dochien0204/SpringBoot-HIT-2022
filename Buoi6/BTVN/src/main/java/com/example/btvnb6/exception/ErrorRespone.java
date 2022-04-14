package com.example.btvnb6.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorRespone {
    private Integer status;
    private String message;

}
