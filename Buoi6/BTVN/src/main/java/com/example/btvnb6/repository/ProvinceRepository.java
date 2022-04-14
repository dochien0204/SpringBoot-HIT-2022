package com.example.btvnb6.repository;

import com.example.btvnb6.entity.District;
import com.example.btvnb6.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Province findProvinceByCode(Long code);
}
