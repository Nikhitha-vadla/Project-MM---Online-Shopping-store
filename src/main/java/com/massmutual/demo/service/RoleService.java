package com.massmutual.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.massmutual.demo.entity.Role;
import com.massmutual.demo.enums.UserRole;
import com.massmutual.demo.repository.RoleRepository;


@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void saveRoleFor(UserRole userRole) {
        Role role = new Role();
        role.setName(userRole.name());
        roleRepository.save(role);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findByRole(UserRole userRole) {
        return roleRepository.findByName(userRole.name());
    }

    public boolean shouldInitialize() {
        return roleRepository.findAll().size() <=0;
    }

    public Role getForAdmin() {
        return findByRole(UserRole.ADMIN);
    }
    public Role getForUser(){return findByRole(UserRole.USER);}

}

