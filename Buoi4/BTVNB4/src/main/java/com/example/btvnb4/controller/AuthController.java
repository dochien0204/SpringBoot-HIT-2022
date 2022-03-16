package com.example.btvnb4.controller;


import com.example.btvnb4.model.User;
import com.example.btvnb4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/login")
    public String loginForm()
    {
        return "login";
    }

    @GetMapping("/users")
    public String getUsers(Model model)
    {
        List<User> users = userRepository.findAll();
        model.addAttribute("users" , users);
        return "users";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user)
    {
        List<User> users = userRepository.findAll();
        for(User u : users)
        {
            if(user.equals(u))
            {
                return "redirect:/users";
            }
        }
        return "login";
    }

    @GetMapping("/create-form")
    public String showForm()
    {
        return "create-form";
    }

    @RequestMapping(value = "/sent-data")
    public String addUser(@ModelAttribute User user)
    {
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit-user/{id}")
    public String editUserForm(@PathVariable Long id, Model model)
    {
        model.addAttribute("userE" , userRepository.findById(id).get());
        return  "edit-user";
    }

    @RequestMapping(value = "/edit", method = {RequestMethod.GET, RequestMethod.PATCH})
    public String editUserByID(@ModelAttribute User user)
    {
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUserById(@PathVariable Long id)
    {
        userRepository.deleteById(id);
        return "redirect:/users";
    }

}
