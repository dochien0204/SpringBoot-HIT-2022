package com.example.kiemtra.service;

import com.example.kiemtra.dto.DarlingDTO;
import com.example.kiemtra.entity.Address;
import com.example.kiemtra.entity.Darling;
import com.example.kiemtra.exception.DuplicateException;
import com.example.kiemtra.exception.NotFoundException;
import com.example.kiemtra.repostitory.AddressRepository;
import com.example.kiemtra.repostitory.DarlingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DarlingServiceImpl implements DarlingService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressService addressService;
    @Autowired
    private DarlingRepository darlingRepository;

    @Autowired
    private AddressRepository addressRepository;

    // Lay tat ca ny cua minh
    @Override
    public List<Darling> findAllDarling() {
        return darlingRepository.findAll();
    }

    //lay ra tat ca ny hien tai
    @Override
    public List<Darling> findDarlingNow() {
        return darlingRepository.findDarlingsNow();
    }

    //lay ra ny dang doi
    @Override
    public List<Darling> findDarlingAnnoy(Integer status) {
        return darlingRepository.findDarlingsByStatus(status);
    }

    //lay ny theo id
    @Override
    public Darling findDarlingById(Long id) {
        Optional<Darling> optional = darlingRepository.findById(id);
        if(optional.isEmpty())
        {
            throw new NotFoundException("Cannot find darling by id " + id);
        }
        return optional.get();
    }

    //them ny
    @Override
    public void createDarling(DarlingDTO darlingDTO) {
        Darling darling = new Darling();
        darling.setName(darlingDTO.getName());
        darling.setPhone(darlingDTO.getPhone());
        darling.setEmail(darlingDTO.getEmail());
        darling.setFavourite(darlingDTO.getFavourite());
        if(darlingDTO.getStatus() > 3 || darlingDTO.getStatus() < 1)
            throw new DuplicateException("Create is not sucessful");
        darling.setStatus(darlingDTO.getStatus());
        darlingRepository.save(darling);
    }

    //sua ny by id
    @Override
    public void updateDarlingsbyId(Long id , DarlingDTO darlingDTO) {
        Optional<Darling> darling = Optional.ofNullable(darlingRepository.findDarlingById(id));
        checkDarling(darling);
        modelMapper.map(darlingDTO,darling.get());
        darlingRepository.save(darling.get());

    }

    @Override
    public void changeDarlingStatus(Long id) {
        Optional<Darling> darling = Optional.ofNullable(darlingRepository.findDarlingById(id));
        checkDarling(darling);
        darling.get().setStatus(3);
        darlingRepository.save(darling.get());
    }

    @Override
    public List<Address> getAdressDarlingById(Long id) {
        Optional<Darling> darling = darlingRepository.findById(id);
        checkDarling(darling);
        return darling.get().getAddressList();

    }

    @Override
    public List<Darling> getDarlingByProvince(String nameProvince) {
        List<Darling> darlings = new ArrayList<>();
        List<Address> addresses = addressRepository.findAll();
        for (Address address : addresses){
            if (address.getName().compareTo(nameProvince) == 0)
                darlings.add(address.getDarling());
        }
        return darlings;
    }


    void checkDarling(Optional<Darling> darling)
    {
        if (darling.isEmpty())
        {
            throw new NotFoundException("Not found this darling");
        }
    }

}
