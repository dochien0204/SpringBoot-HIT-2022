package com.example.btvnb5.Services;

import com.example.btvnb5.DTO.UrlLinkDTO;
import com.example.btvnb5.Model.UrlLink;
import com.example.btvnb5.Repository.UrlLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class UrlLinkServicesImp implements UrlLinkServices {

    @Autowired
    private UrlLinkRepository urlLinkRepository;

    static Random generator = new Random();

    @Override
    public List<UrlLink> getAllUrlLink() {
        return urlLinkRepository.findAll();
    }

    @Override
    public String generateShortLink(UrlLinkDTO urlLinkDTO) {
        UrlLink url = new UrlLink();
      List<UrlLink> urls = urlLinkRepository.findAll();
      if (urlLinkDTO.getOriginalLink().compareTo("") == 0) {
          return "Link cần short không được rỗng";
      }
      for(UrlLink u : urls)
      {
          if (u.getOriginalLink().compareTo(urlLinkDTO.getOriginalLink()) == 0 )
              return "Link này đã được short, short không thành công !";
      }

      url.setOriginalLink(urlLinkDTO.getOriginalLink());
      String encode = encodeUrl();
      int i = 0;
      while (i < urls.size())
      {
          if(urls.get(i).getShortedLink().compareTo(encode) == 0)
          {
              encode = encodeUrl();
              i = 0;
          }
           i++;
      }
      url.setShortedLink(encode);
      urlLinkRepository.save(url);
      return "Short link thành công";
    }



    @Override
    public UrlLink findByShortedLink(String shortedLink) {
        return urlLinkRepository.findUrlLinkByShortedLink(shortedLink);
    }



    public static String encodeUrl()
    {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String alphaUpperCase = alpha.toUpperCase(); // A-Z
        String digits = "0123456789"; // 0-9
        String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
        StringBuilder encode =  new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            encode.append(ch);
        }
        return encode.toString();
    }
    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }


}
