package com.sti.ssm.dto;

public class CompanyDetailsDTO {

	int id;
	String companyName;
	String abbreviation;
	AddressDTO details;
	AddressDTO billingAddress;
	AddressDTO contactAddress;
	CompanyContactDTO companyContact;
	
	public CompanyDetailsDTO() {}
	
	public CompanyDetailsDTO(String name, String abbreviation, AddressDTO details, AddressDTO billingAddress,
			AddressDTO contactAddress, CompanyContactDTO companyContact) {
		super();
		this.companyName = name;
		this.abbreviation = abbreviation;
		this.details = details;
		this.billingAddress = billingAddress;
		this.contactAddress = contactAddress;
		this.companyContact = companyContact;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public AddressDTO getDetails() {
		return details;
	}
	public void setDetails(AddressDTO details) {
		this.details = details;
	}
	public AddressDTO getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(AddressDTO billingAddress) {
		this.billingAddress = billingAddress;
	}
	public AddressDTO getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(AddressDTO contactAddress) {
		this.contactAddress = contactAddress;
	}
	public CompanyContactDTO getCompanyContact() {
		return companyContact;
	}
	public void setCompanyContact(CompanyContactDTO companyContact) {
		this.companyContact = companyContact;
	}
	
	
}
