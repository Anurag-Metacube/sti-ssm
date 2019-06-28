package com.sti.ssm.models;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
@Entity
public class CompanyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	int id;
	
	String companyName;
	

	String abbreviation;
	
	@OneToOne(cascade = {CascadeType.ALL})
	Address details;
	

	@OneToOne(cascade = {CascadeType.ALL})
	Address billingAddress;
	
	@OneToOne(cascade = {CascadeType.ALL})
	Address contactAddress;
	
	@OneToOne(cascade = {CascadeType.ALL})
	CompanyContact companyContact;
	
	public CompanyDetails() {}

	public CompanyDetails(String companyName, String abbreviation, Address details, Address billingAddress,
			Address contactAddress, CompanyContact companyContact) {
		super();
		this.companyName = companyName;
		this.abbreviation = abbreviation;
		this.details = details;
		this.billingAddress = billingAddress;
		this.contactAddress = contactAddress;
		this.companyContact = companyContact;
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

	public Address getDetails() {
		return details;
	}

	public void setDetails(Address details) {
		this.details = details;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public CompanyContact getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(CompanyContact companyContact) {
		this.companyContact = companyContact;
	}

	
	
}
