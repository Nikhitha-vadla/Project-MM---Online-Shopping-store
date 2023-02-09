package com.massmutual.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.massmutual.demo.entity.User;
import com.massmutual.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{customerID}")
    public String deleteCustomerById(@PathVariable("customerID")Long customerID) {
        userService.deleteCustomerById(customerID);
        return "Customer Deleted successfully";
    }

    @PutMapping("/update/{customerID}")
    public ResponseEntity<User> updateCustomer(@PathVariable("customerID") Long customerID, @RequestBody User customer) {
        User updatedUser = userService.updateCustomer(customerID, customer);
        return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/get")
    public List<User> fetchCustomerList(){
        return userService.fetchCustomerList();
    }

    @GetMapping("/get/{customerID}")
    public ResponseEntity<User> fetchCustomerById(@PathVariable("customerID") Long customerID) {
        User customer = userService.fetchCustomerById(customerID);
        return new ResponseEntity<User>(customer, HttpStatus.OK);
    }

    @GetMapping("/get/name/{name}")
    public ResponseEntity<User> fetchCustomerByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(userService.fetchCustomerByName(name),HttpStatus.OK);
    }

}
