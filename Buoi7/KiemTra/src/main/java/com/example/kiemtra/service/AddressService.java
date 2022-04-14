package com.example.kiemtra.service;

import com.example.kiemtra.dto.AddressDTO;
import com.example.kiemtra.entity.Address;

import java.util.List;

public interface AddressService {
    void createdAddress(Long id, AddressDTO addressDTO);

    List<Address> findAllAddress();

    void updateAddressDarlingById(Long darlingId,Long id ,AddressDTO addressDTO);
}
