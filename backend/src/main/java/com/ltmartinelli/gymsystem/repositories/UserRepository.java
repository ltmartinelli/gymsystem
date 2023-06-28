package com.ltmartinelli.gymsystem.repositories;

import com.ltmartinelli.gymsystem.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query(
            "SELECT obj FROM User obj " +
                    "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%')) ")
    Page<User> searchByName(String name, Pageable pageable);
}
