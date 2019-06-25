package com.sti.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sti.ssm.models.UserDetails;
import com.sti.ssm.service.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(method=RequestMethod.POST, value="/addUser")
	public void addUser(@RequestBody UserDetails user) {
		service.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/user/{ssn}")
	public UserDetails getUser(@PathVariable int ssn) {
		return service.getUser(ssn);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/users")
	public List<UserDetails> getAllUsers() {
		return service.getAllUsers();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/user/{ssn}")
	public void deleteUserBySsn(@PathVariable int ssn) {
		service.deleteUserBySsn(ssn);
	}
}
