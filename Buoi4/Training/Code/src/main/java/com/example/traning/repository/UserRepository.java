package com.example.traning.repository;

import com.example.traning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findAllByPasswordContaining(String key);

    @Query(value = "select * from Users where id ><", nativeQuery = true)
    List<User> findAllByPasswordContaining2();
}
