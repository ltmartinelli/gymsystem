package com.ltmartinelli.gymsystem.services;

import com.ltmartinelli.gymsystem.entities.User;
import com.ltmartinelli.gymsystem.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserService userService;

    public void validateSelfOrAdmin(Long userId){

        User me = userService.authenticated();
        if(!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)){
            throw new ForbiddenException("Access denied");
        }
    }
}
