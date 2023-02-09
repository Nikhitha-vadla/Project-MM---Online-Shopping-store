package com.massmutual.demo.register;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.massmutual.demo.entity.User;
import com.massmutual.demo.enums.UserRole;
import com.massmutual.demo.exceptions.AppException;
import com.massmutual.demo.service.UserServiceImpl;

@Service
public class RegisterService {

    @Autowired
    private UserServiceImpl userService;

    public User addUser(RegisterRequest user){

        if(null!= userService.findByUserName(user.getUserName())){
            throw new AppException("Username already exists "+ user.getUserName());
        }

        if(null != userService.findByEmail(user.getEmail())) {
            throw new AppException("User with Same email already exists " + user.getEmail());
        }

        if(null != userService.findByPhone(user.getPhoneNumber())){
            throw new AppException("User with Same Phone number already exists " + user.getPhoneNumber());
        }

        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setRoles(userService.getRoleFor(UserRole.USER));
        newUser.setCreated(LocalDateTime.now());
        newUser.setPassword(userService.toEncrypted(user.getPassword()));
        newUser.setAddress(user.getAddress());

        User updatedUser = userService.saveInDatabase(newUser);
        return updatedUser;


    }
}
