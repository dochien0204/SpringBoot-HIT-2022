package com.example.phan1.services;

import com.example.phan1.dto.UserDTO;
import com.example.phan1.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUser();

    void createNewUser(UserDTO userDTO);
}
