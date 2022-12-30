package com.massmutual.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.massmutual.demo.entity.LoginDetails;

@Repository
public interface LoginRepository extends JpaRepository<LoginDetails, Long> {

	@Query(value = "SELECT * FROM logindetails ld WHERE ld.userID = ?1 and ld.password = ?2", 
	nativeQuery = true)
	
	LoginDetails validateLogin(Long userID,String password);

	
}
