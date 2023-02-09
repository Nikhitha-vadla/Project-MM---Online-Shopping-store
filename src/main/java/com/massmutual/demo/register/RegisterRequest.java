package com.massmutual.demo.register;

import java.time.LocalDateTime;

import com.massmutual.demo.entity.Address;

import lombok.Data;

@Data
public class RegisterRequest {

    private String userName;

    private String password;

    private LocalDateTime created;

    private String name;

    private String email;

    private Address address;

    private String phoneNumber;
}
