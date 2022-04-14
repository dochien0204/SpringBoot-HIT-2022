package com.example.kiemtra.repostitory;

import com.example.kiemtra.entity.Darling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DarlingRepository  extends JpaRepository<Darling,Long> {
    Darling findDarlingByStatus(Integer status);

    @Query("select d from Darling d where d.status = 1 or d.status = 2")
    List<Darling> findDarlingsNow();
    Darling findDarlingById(Long id);
    List<Darling> findDarlingsByStatus(Integer status);
}
