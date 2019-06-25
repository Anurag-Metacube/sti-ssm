package com.sti.ssm.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sti.ssm.dao.UserDao;
import com.sti.ssm.models.UserDetails;



@Service
public class UserService {
	
	@Autowired
	UserDao dao;
	
	public void addUser(UserDetails user) {
		dao.addUser(user);
	}
	
	public UserDetails getUser (int ssn) {
		return dao.getUser(ssn);
	}
	
	public List<UserDetails> getAllUsers(){
		return dao.getAllUsers();
	}

	public void deleteUserBySsn(int ssn) {
		dao.deleteUserBySsn(ssn);
		
	}
	
}
