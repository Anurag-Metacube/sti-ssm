package com.sti.ssm.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class CompanyDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	Address contractAddress;
	
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
		this.contractAddress = contactAddress;
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

	public Address getContractAddress() {
		return contractAddress;
	}

	public void setContractAddress(Address contactAddress) {
		this.contractAddress = contactAddress;
	}

	public CompanyContact getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(CompanyContact companyContact) {
		this.companyContact = companyContact;
	}

	
	
}
