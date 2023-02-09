package com.massmutual.demo.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.massmutual.demo.entity.User;
import com.massmutual.demo.service.UserServiceImpl;

@Component
public class UserLoggedInService {

    private UserServiceImpl userService;

    @Autowired
    public UserLoggedInService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public User getLoggedInUser() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.findByUserName(principal.getUsername());

    }
}
