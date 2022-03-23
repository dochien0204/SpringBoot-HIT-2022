package com.example.btvnb5.Services;

import com.example.btvnb5.DTO.UrlLinkDTO;
import com.example.btvnb5.Model.UrlLink;


import java.util.List;



public interface UrlLinkServices {

    List<UrlLink> getAllUrlLink();

     String generateShortLink(UrlLinkDTO urlLinkDTO);

     UrlLink findByShortedLink(String shortedLink);



}
