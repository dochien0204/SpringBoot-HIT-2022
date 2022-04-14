package com.example.phan1.services;

import com.example.phan1.dto.UserDTO;
import com.example.phan1.models.User;
import com.example.phan1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void createNewUser(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());

        userRepository.save(user);
    }
}
