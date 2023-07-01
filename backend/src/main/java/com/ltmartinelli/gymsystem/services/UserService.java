package com.ltmartinelli.gymsystem.services;

import com.ltmartinelli.gymsystem.dto.UserMinDTO;
import com.ltmartinelli.gymsystem.entities.User;
import com.ltmartinelli.gymsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Email not found");
        }
        return user;
    }

    @Transactional(readOnly = true)
    public Page<UserMinDTO> searchByName(String name, Pageable pageable) {
        Page<User> users = repository.searchByName(name, pageable);
        return users.map(user -> new UserMinDTO(user));
    }
}
