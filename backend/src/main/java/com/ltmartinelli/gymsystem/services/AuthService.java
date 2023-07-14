package com.ltmartinelli.gymsystem.services;

import com.ltmartinelli.gymsystem.entities.User;
import com.ltmartinelli.gymsystem.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserService userService;

    //Throws and exception if the user trying to access a resource is not an Admin or related to that resource
    //Provide the ID of that resource's user as a parameter, and the method will check if the logged user is that same user
    public void validateSelfOrAdmin(Long userId) {
        User me = userService.authenticated();
        if (!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
            throw new ForbiddenException("Access denied");
        }
    }
}
