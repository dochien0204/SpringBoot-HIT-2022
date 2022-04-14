package com.example.phan1.controllers;

import com.example.phan1.dto.UserDTO;
import com.example.phan1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }

    @PostMapping
    public ResponseEntity<?> createNewUser(@RequestBody UserDTO userDTO)
    {
        userService.createNewUser(userDTO);
        return ResponseEntity.status(200).body("Add sucesfully");
    }
}
