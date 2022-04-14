package com.example.btvnb6.service;

import com.example.btvnb6.dto.DistrictDTO;
import com.example.btvnb6.entity.District;
import com.example.btvnb6.entity.Province;
import com.example.btvnb6.exception.NotFoundException;
import com.example.btvnb6.repository.DistrictRepository;
import com.example.btvnb6.repository.ProvinceRepository;
import com.github.slugify.Slugify;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService{
    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private DistrictDTO districtDTO;

    @Autowired
    private Slugify slug;

    private ModelMapper mapper;
    @Override
    public List<District> findAllDistrict() {

        return districtRepository.findAll();
    }


    @Override
    public District findDistrictById(Long id) {
        Optional<District> district = districtRepository.findById(id);
        check(district);
        return district.get();
    }

    @Override
    public District createDistrict(DistrictDTO districtDTO) {
        Province province = provinceRepository.findProvinceByCode(districtDTO.getCode());

        
        return ;
    }


    @Override
    public District createDistrict(DistrictDTO districtDTO) {

        District district = new District();
        district.setName(districtDTO.getName());
        district.setType(districtDTO.getType());
        district.setSlug(slug.slugify(district.getName()));
        district.setNameWithType(district.getType() + " " + district.getName());
        district.setPathWithType(district.getNameWithType());
        return district;

    }

    @Override
    public void deleteDistrict(Long id) {
        District district = districtRepository.findDistrictByCode(id);
        districtRepository.delete(district);

    }

    @Override
    public District updateDistrict(Long id) {
        return null;
    }

    public void check(Optional<District> district){
        if(district.isEmpty()){
            throw new NotFoundException("Khong tim thay district");
        }
    }
}
