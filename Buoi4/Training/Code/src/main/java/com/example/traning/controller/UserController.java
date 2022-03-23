package com.example.traning.controller;

import com.example.traning.dto.UserDTO;
import com.example.traning.model.User;
import com.example.traning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/users")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> getAllUser()
    {
        return ResponseEntity.status(200).body(userRepository.findAllByPasswordContaining2());
    }


    @PostMapping
    public ResponseEntity<?> createNewUser(@RequestBody UserDTO userDTO)
    {
        User user = new User();
        user.setUserName(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());

        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tạo thành công");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(name = "id") Long id )
    {
        Optional<User> user = userRepository.findById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user.get());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> editUserById(@PathVariable("id") Long id,
                                          @RequestBody UserDTO userDTO)
    {
        User user = userRepository.getById(id);
        user.setUserName(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getPassword());

        userRepository.save(user);
        return ResponseEntity.status(200).body("Sửa thành công");
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteUserById(@PathVariable("id") Long id)
    {
        //xử lí exception

        userRepository.deleteById(id);
        return ResponseEntity.status(200).body("Xóa thành công user có id " + id);
    }
}
