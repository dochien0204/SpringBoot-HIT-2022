package com.example.btvnb6.service;


import com.example.btvnb6.entity.Province;
import com.example.btvnb6.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProvinceServiceImpl  implements  ProvinceService{
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public Province findProvinceByCode(Long code) {
        return provinceRepository.findProvinceByCode(code);
    }
}
