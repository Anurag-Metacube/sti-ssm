package com.sti.ssm.pojo;

import com.sti.ssm.models.Address;

public class CompanyContactPOJO {

	String firstName;
	String lastName;
	String emailId;
	
	Address contactAddress;

	public CompanyContactPOJO() {}
	
	public CompanyContactPOJO( String firstName, String lastName, String emailId,
			Address contactAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contactAddress = contactAddress;
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

	public Address getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(Address contactAddress) {
		this.contactAddress = contactAddress;
	}
	
	
}
