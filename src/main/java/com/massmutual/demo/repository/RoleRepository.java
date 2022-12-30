package com.massmutual.demo.repository;

import com.massmutual.demo.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
    List<Role> findAll();



}
