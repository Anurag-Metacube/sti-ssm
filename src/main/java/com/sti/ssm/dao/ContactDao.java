package com.sti.ssm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.sti.ssm.models.Address;
import com.sti.ssm.models.CompanyContact;
import com.sti.ssm.repo.ContactRepo;

@Service
public class ContactDao {

	@Autowired
	ContactRepo repo;
	
	public void add(CompanyContact contact) {
		repo.save(contact);
	}
	
}
