package com.example.trainingb7.config;


import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary config()
    {

        Map<String, String > config = new HashMap<>();
        config.put("cloud_name" , "dochien-com");
        config.put("api_key", "213175897195632");
        config.put("api_secret" , "mItBDywcQ-sWrDX4e9Y21FfjFR0");

        return new Cloudinary(config);
    }
}
