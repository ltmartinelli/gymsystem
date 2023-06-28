package com.ltmartinelli.gymsystem.repositories;

import com.ltmartinelli.gymsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
