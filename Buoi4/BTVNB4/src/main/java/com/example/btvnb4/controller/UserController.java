package com.example.btvnb4.controller;


import com.example.btvnb4.dto.UserDTO;
import com.example.btvnb4.model.User;
import com.example.btvnb4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping
    public ResponseEntity<?> getAllUser()
    {
        List<User> users = userRepository.findAll();
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id)
    {
        Optional<User> user = userRepository.findById(id);
        return ResponseEntity.status(200).body(user.get());
    }

    @PostMapping
    public ResponseEntity<?> createNewUser(
            @RequestBody UserDTO userDTO
    )
    {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());

        userRepository.save(user);

        return ResponseEntity.status(200).body("Tạo thành công user mới");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUserById(
            @PathVariable("id") Long id,
            @RequestBody UserDTO userDTO
    )
    {
        User user = userRepository.getById(id);

        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());

        userRepository.save(user);

        return ResponseEntity.status(200).body("Sửa thành công User có id " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id)
    {
        userRepository.deleteById(id);
        return ResponseEntity.status(200).body("Xóa thành công User có id " + id);
    }

}
