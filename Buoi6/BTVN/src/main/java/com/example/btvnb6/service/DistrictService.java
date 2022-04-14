package com.example.btvnb6.service;

import com.example.btvnb6.dto.DistrictDTO;
import com.example.btvnb6.entity.District;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DistrictService {
    List<District> findAllDistrict();

    District findDistrictById(Long id);

    District createDistrict(DistrictDTO districtDTO);

    void deleteDistrict(Long id);

    District updateDistrict(Long id);


}
