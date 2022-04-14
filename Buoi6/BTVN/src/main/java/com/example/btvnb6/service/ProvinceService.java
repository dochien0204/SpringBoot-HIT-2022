package com.example.btvnb6.service;

import com.example.btvnb6.entity.Province;
import com.example.btvnb6.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface ProvinceService {
    @Autowired
    Province findProvinceByCode(Long code);
}
