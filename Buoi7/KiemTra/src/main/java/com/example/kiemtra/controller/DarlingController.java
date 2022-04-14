package com.example.kiemtra.controller;

import com.example.kiemtra.dto.DarlingDTO;
import com.example.kiemtra.entity.Darling;
import com.example.kiemtra.service.DarlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/darlings")
public class DarlingController {

    @Autowired
    private DarlingService darlingService;

    @GetMapping
    public ResponseEntity<?> findAllDarling()
    {
        return ResponseEntity.status(200).body(darlingService.findAllDarling());
    }

    @GetMapping
    @RequestMapping("/current")
    public ResponseEntity<?> findDarlingCurrent()
    {
        return ResponseEntity.status(200).body(darlingService.findDarlingNow());
    }

    //lay ny dang gian
    @GetMapping("/annoy")
    public ResponseEntity<?> findDarlingAnnoy(@RequestParam(name = "status") Integer status)
    {
        return ResponseEntity.status(200).body(darlingService.findDarlingAnnoy(status));
    }

    //lay ny theo id
    @GetMapping("/{id}")
    public ResponseEntity<?> findDarlingById(@PathVariable("id") Long id)
    {
        return ResponseEntity.status(200).body(darlingService.findDarlingById(id));
    }

    //them ny
    @PostMapping
    public ResponseEntity<?> createDarling(@RequestBody DarlingDTO darlingDTO)
    {
        darlingService.createDarling(darlingDTO);
        return ResponseEntity.status(201).body("Created successfull");
    }

    //sua ny theo id
    @PatchMapping("/{id}")
    private ResponseEntity<?> updateDarlingById(@RequestBody DarlingDTO darlingDTO,
                                                @PathVariable Long id)
    {
        darlingService.updateDarlingsbyId(id, darlingDTO);
        return ResponseEntity.status(200).body("Update successful");
    }

    //thay doi ny -> nyc
    @PatchMapping("/{id}/nyc")
    private ResponseEntity<?> changeDarlingStatus(@PathVariable Long id)
    {
        darlingService.changeDarlingStatus(id);
        return ResponseEntity.status(200).body("Change sucessful");
    }

    @GetMapping("/{id}/address")
    private ResponseEntity<?> getAddressDarlingById(@PathVariable Long id)
    {
        return ResponseEntity.status(200).body(darlingService.getAdressDarlingById(id));
    }

    @GetMapping("/address/name")
    private ResponseEntity<?> getDarlingByAddress(@RequestParam(name = "q") String nameProvince)
    {
       return ResponseEntity.status(200).body(darlingService.getDarlingByProvince(nameProvince));
    }

}
