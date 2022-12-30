package com.massmutual.demo.service;

import com.massmutual.demo.entity.LoginDetails;
import com.massmutual.demo.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository repository;


	
	@Override
	public LoginDetails saveLogin(LoginDetails login) {
		return repository.save(login);
		

	}

	@Override
	public LoginDetails validateLogin(Long userID, String password) {
		return repository.validateLogin(userID,password);

	}

	@Override
	public void deleteUserById(Long userID) {
		repository.deleteById(userID);
		
		
	}

}
