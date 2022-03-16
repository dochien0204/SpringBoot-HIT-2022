package com.example.btvnb3;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping(value = "/login")
    public String login()
    {
        return "login";
    }

    @PostMapping("/listUsers")
    public String listUsers(@ModelAttribute User user, Model model)
    {

        if(Store.check(user))
        {
            model.addAttribute("list", Store.listUser);
            return "listUsers";
        }
        return "redirect:login";

    }




}
