package com.massmutual.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.massmutual.demo.entity.Role;
import com.massmutual.demo.entity.User;
import com.massmutual.demo.enums.UserRole;
import com.massmutual.demo.register.RegisterRequest;

public interface UserService {

    public User findByEmail(String email);

    public User findByPhone(String phone);

    public User saveInDatabase(User newUser);

    public void validateUserWithSameDataExists(RegisterRequest user);

    public List<User> findAll();

    public Optional<User> findById(long id);

    public User addAdmin(RegisterRequest user);

    public Set<Role> getRoleFor(UserRole userRole);

    public String toEncrypted(String password);


    public List<User> fetchCustomerList();

    public User fetchCustomerById(Long userId);

    public void deleteCustomerById(Long userId);

    public User updateCustomer(Long customerID, User customer);

    public User fetchCustomerByName(String name);

}
