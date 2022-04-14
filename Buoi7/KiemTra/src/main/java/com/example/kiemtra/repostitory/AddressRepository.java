package com.example.kiemtra.repostitory;

import com.example.kiemtra.entity.Address;
import com.example.kiemtra.entity.Darling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
