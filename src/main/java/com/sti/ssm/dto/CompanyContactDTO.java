package com.sti.ssm.dto;

import com.sti.ssm.models.Address;

public class CompanyContactDTO {

	int id;
	String firstName;
	String lastName;
	String emailId;
	
	AddressDTO contactAddress;

	public CompanyContactDTO() {}
	
	public CompanyContactDTO( String firstName, String lastName, String emailId,
			AddressDTO contactAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contactAddress = contactAddress;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public AddressDTO getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(AddressDTO contactAddress) {
		this.contactAddress = contactAddress;
	}
	
	
}
