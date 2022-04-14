package com.example.btvnb6.repository;

import com.example.btvnb6.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
    District findDistrictByCode(Long code);

}
