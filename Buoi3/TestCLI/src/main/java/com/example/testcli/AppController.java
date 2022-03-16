package com.example.testcli;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppController {
    @Value("${chien.name}")
    private String name;

    @GetMapping
    public String getString()
    {
        return name;
    }


//    @GetMapping("/{id}")
//    public String getID(@PathVariable("id") String id)
//    {
//        return id;
//    }


    @GetMapping("/{id}/{username}")
    public String getIDbyNumber(@PathVariable("id") Long id,
                                @PathVariable("username") String userName)
    {
        return userName + id + "";
    }

    @GetMapping("/rqparam")
    public String getIDbyRequestParam(@RequestParam(value = "name", required = false) String name)
    {
        return name;
    }
}
