package com.sti.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sti.ssm.dao.AddressDao;
import com.sti.ssm.models.Address;

@Service
public class AddressService {
	
	@Autowired
	AddressDao dao;
	
	public Address addAddress(Address address) {
		return dao.save(address);
	}
	
}
