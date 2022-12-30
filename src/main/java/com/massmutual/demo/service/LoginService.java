package com.massmutual.demo.service;

import com.massmutual.demo.entity.LoginDetails;

public interface LoginService {
	
	LoginDetails saveLogin(LoginDetails login);

	LoginDetails validateLogin(Long userID, String password);

	void deleteUserById(Long userID);

}
