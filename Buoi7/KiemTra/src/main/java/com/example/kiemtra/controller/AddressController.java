package com.example.kiemtra.controller;


import com.example.kiemtra.dto.AddressDTO;
import com.example.kiemtra.service.AddressService;
import com.example.kiemtra.service.DarlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/addresses")
public class AddressController {

    @Autowired
    private DarlingService darlingService;

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<?> getAllAdress()
    {
        return ResponseEntity.status(200).body(addressService.findAllAddress());
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> createdAddress(@PathVariable Long id,
                                            @RequestBody AddressDTO addressDTO)
    {
        addressService.createdAddress(id,addressDTO);
        return ResponseEntity.status(200).body("Created address for Darling id = " + id);
    }

    @PatchMapping("/{darLingId}/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable(name = "darlingId") Long darlingId,
                                           @PathVariable(name = "id") Long id,
                                           @RequestBody AddressDTO addressDTO)
    {
        addressService.updateAddressDarlingById(darlingId,id, addressDTO);
        return ResponseEntity.status(200).body("Updated successful");
    }


}
