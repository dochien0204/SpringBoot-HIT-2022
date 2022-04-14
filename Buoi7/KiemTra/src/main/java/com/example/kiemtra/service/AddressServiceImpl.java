package com.example.kiemtra.service;

import com.example.kiemtra.dto.AddressDTO;
import com.example.kiemtra.entity.Address;
import com.example.kiemtra.entity.Darling;
import com.example.kiemtra.exception.NotFoundException;
import com.example.kiemtra.repostitory.AddressRepository;
import com.example.kiemtra.repostitory.DarlingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DarlingRepository darlingRepository;
    @Override
    public void createdAddress(Long id, AddressDTO addressDTO) {
        Address address = new Address();
        Darling darling = darlingRepository.findDarlingById(id);
        address.setName(addressDTO.getName());
        address.setCode(addressDTO.getCode());
        address.setDarling(darling);
        addressRepository.save(address);
    }

    @Override
    public List<Address> findAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public void updateAddressDarlingById(Long darlingId, Long id, AddressDTO addressDTO) {
        Optional<Darling> darling = darlingRepository.findById(darlingId);
        checkDarling(darling);
        Optional<Address> address = addressRepository.findById(id);
        checkAddress(address);
        modelMapper.map(addressDTO, address.get());
        addressRepository.save(address.get());
    }

    public void checkDarling(Optional<Darling> darling ){
        if(darling.isEmpty()) {
            throw new NotFoundException("Darling's not found");
        }
    }
    public void checkAddress(Optional<Address> address)
    {
        if (address.isEmpty())
            throw new NotFoundException("Address's not found");
    }
}
