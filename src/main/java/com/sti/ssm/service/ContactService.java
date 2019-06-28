package com.sti.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sti.ssm.dao.ContactDao;
import com.sti.ssm.models.CompanyContact;

@Service
public class ContactService {

	@Autowired
	ContactDao dao;
	
	public void addContact(CompanyContact contact) {
		dao.add(contact);
	}
	
}
