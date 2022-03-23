package com.example.trainingb7.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private Cloudinary cloudinary;

    @PostMapping("/avt")
    public ResponseEntity<?> getAvt(@RequestParam("file") MultipartFile file)
    {
        try{
            Map<?,?> map = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            System.out.println(map.get("secure_url"));
            return ResponseEntity.status(200).body(map);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(200).body(null);

    }


}
