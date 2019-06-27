package com.sti.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sti.ssm.dao.CompanyDao;
import com.sti.ssm.models.Address;
import com.sti.ssm.models.CompanyContact;
import com.sti.ssm.models.CompanyDetails;
import com.sti.ssm.pojo.CompanyContactPOJO;
import com.sti.ssm.pojo.CompanyDetailsPOJO;



@Service
public class CompanyService {
	
	@Autowired
	CompanyDao dao;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	ContactService contactService;
	
	public void addCompany(CompanyDetailsPOJO companyPOJO) {
		String companyName = companyPOJO.getName();
		Address details = companyPOJO.getDetails();
		details.setType("Details");
		details.setCompanyName(companyName);
		addressService.addAddress(details);
		Address contact = companyPOJO.getContactAddress();
		contact.setType("Contact");
		contact.setCompanyName(companyName);
		addressService.addAddress(contact);
		Address billing = companyPOJO.getBillingAddress();
		billing.setType("Billing");
		billing.setCompanyName(companyName);
		addressService.addAddress(billing);
		CompanyContactPOJO companyContactPOJO = companyPOJO.getCompanyContact();
		Address companyContactAddress = companyContactPOJO.getContactAddress();
		companyContactAddress.setType("CompanyContactAddress");
		companyContactAddress.setCompanyName(companyName);
		addressService.addAddress(companyContactAddress);
		CompanyContact companyContact = new CompanyContact();
		companyContact.setFirstName(companyContactPOJO.getFirstName());
		companyContact.setLastName(companyContactPOJO.getLastName());
		companyContact.setEmailId(companyContactPOJO.getEmailId());
		companyContact.setAllContactAddress(addressService.getAddress(companyName, "CompanyContactAddress"));
		CompanyDetails company = new CompanyDetails(
				companyName,companyPOJO.getAbbreviation(),
				addressService.getAddress(companyName, "Details"), addressService.getAddress(companyName, "Billing"),
				addressService.getAddress(companyName, "Contact"), companyContact
				);
		addressService.deleteAllByCompanyName(companyName);
		dao.addCompany(company);
	}
	
	public CompanyDetails getCompany (int id) {
		return dao.getCompany(id);
	}
	
	public List<CompanyDetails> getAllCompanies(){
		return dao.getAllCompanies();
	}

	public void deleteCompanyById(int id) {
		dao.deleteCompanyById(id);
		
	}
	
}
