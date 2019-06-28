package com.sti.ssm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sti.ssm.models.Address;
import com.sti.ssm.repo.AddressRepo;

@Service
public class AddressDao {

	@Autowired
	AddressRepo repo;
	
	public Address save(Address address) {
		return repo.save(address);
	}
	
}
