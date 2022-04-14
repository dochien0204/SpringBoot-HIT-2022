package com.example.kiemtra.service;


import com.example.kiemtra.dto.DarlingDTO;
import com.example.kiemtra.entity.Address;
import com.example.kiemtra.entity.Darling;

import java.util.List;

public interface DarlingService {
    List<Darling> findAllDarling();

    List<Darling> findDarlingNow();

    List<Darling> findDarlingAnnoy(Integer status);

    Darling findDarlingById(Long id);

    void createDarling(DarlingDTO darlingDTO);

    void updateDarlingsbyId(Long id, DarlingDTO darlingDTO);

    void changeDarlingStatus(Long id);

    List<Address> getAdressDarlingById(Long id);

     List<Darling> getDarlingByProvince(String nameProvince);
}
