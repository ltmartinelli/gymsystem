package com.ltmartinelli.gymsystem.services;

import com.ltmartinelli.gymsystem.dto.UserMinDTO;
import com.ltmartinelli.gymsystem.entities.User;
import com.ltmartinelli.gymsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public Page<UserMinDTO> searchByName(String name, Pageable pageable) {
        Page<User> users = repository.searchByName(name, pageable);
        return users.map(user -> new UserMinDTO(user));
    }
}
