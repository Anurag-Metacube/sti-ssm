package com.sti.ssm.pojo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;

import com.sti.ssm.models.Address;

public class CompanyDetailsPOJO {

	String name;
	String abbreviation;
	
	
	Address details;
	Address billingAddress;
	Address contactAddress;
	CompanyContactPOJO companyContact;
	
	public CompanyDetailsPOJO() {}
	
	public CompanyDetailsPOJO(String name, String abbreviation, Address details, Address billingAddress,
			Address contactAddress, CompanyContactPOJO companyContact) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.details = details;
		this.billingAddress = billingAddress;
		this.contactAddress = contactAddress;
		this.companyContact = companyContact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public Address getDetails() {
		return details;
	}
	public void setDetails(Address details) {
		this.details = details;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Address getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(Address contactAddress) {
		this.contactAddress = contactAddress;
	}
	public CompanyContactPOJO getCompanyContact() {
		return companyContact;
	}
	public void setCompanyContact(CompanyContactPOJO companyContact) {
		this.companyContact = companyContact;
	}
	
	
}
