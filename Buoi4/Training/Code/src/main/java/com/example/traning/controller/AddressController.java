package com.example.traning.controller;


import com.example.traning.dto.AddressDTO;
import com.example.traning.model.Address;
import com.example.traning.model.User;
import com.example.traning.repository.AddressRepository;
import com.example.traning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/address")
@RestController
public class AddressController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public ResponseEntity<?> getAllAddress()
    {
        return ResponseEntity.status(200).body(addressRepository.findAll());
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> createNewAddress(@RequestBody AddressDTO addressDTO,
                                           @PathVariable(name = "id") Long userId)
    {
        Address address = new Address();
        address.setVal(addressDTO.getVal());

        if(userId != null)
        {
            User user = userRepository.findById(userId).get();
            address.setUser(user);
        }
        addressRepository.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tạo address thành công");
    }

}
