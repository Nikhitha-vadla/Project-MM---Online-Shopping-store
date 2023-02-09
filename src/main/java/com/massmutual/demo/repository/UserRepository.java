package com.massmutual.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.massmutual.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String username);

    User findByEmail(String email);
    User findByPhoneNumber(String phoneNumber);

    List<User> findAllByRoles(String role);

    User findByNameAndRoles(String name,String role);

    @Query(value = "select * from `sprint`.`user` where user_id=:userID",nativeQuery = true)
    User findByUser_id(@Param("userID") long userId);



}
