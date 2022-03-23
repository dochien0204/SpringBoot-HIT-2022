package com.example.btvnb5.Controller;

import com.example.btvnb5.DTO.UrlLinkDTO;
import com.example.btvnb5.Services.UrlLinkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/v1/url")
public class UrlLinkController {


    @Autowired
    private UrlLinkServices urlLinkServices;

    @GetMapping()
    public ResponseEntity<?> getAllUrl()
    {
        return ResponseEntity.status(200).body(urlLinkServices.getAllUrlLink());
    }


    @PostMapping
    public ResponseEntity<?> generatedShortLink(@RequestBody UrlLinkDTO urlLinkDTO)
    {
        return ResponseEntity.status(200).body(urlLinkServices.generateShortLink(urlLinkDTO));

    }

    @GetMapping("/{shortedLink}")
    public ModelAndView getUrlByShotedLink(@PathVariable(name = "shortedLink") String shortedLink)
    {
      return new ModelAndView("redirect:" + urlLinkServices.findByShortedLink(shortedLink).getOriginalLink());
    }

}
