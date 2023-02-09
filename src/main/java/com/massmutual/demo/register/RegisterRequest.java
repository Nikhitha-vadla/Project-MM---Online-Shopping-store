package com.massmutual.demo.register;

import com.massmutual.demo.entity.Address;
import lombok.Data;
import java.time.LocalDateTime;

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
