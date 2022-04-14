package com.example.kiemtra.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorRespone {
    private Integer code;
    private String status;

}
