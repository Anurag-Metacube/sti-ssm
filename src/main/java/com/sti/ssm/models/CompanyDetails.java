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
	
	String name;
	
	String abbreviation;
	
	@OneToMany(cascade = {CascadeType.ALL})
	List<Address> allDetails;
	
	@OneToMany(cascade = {CascadeType.ALL})
	List<Address> allBillingAddress;
	
	@OneToMany(cascade = {CascadeType.ALL})
	List<Address> allContactAddress;
	
	@OneToOne(cascade = {CascadeType.ALL})
	CompanyContact companyContact;
	
	public CompanyDetails() {}

	public CompanyDetails(String name, String abbreviation, List<Address> details, List<Address> billingAddress,List<Address> contactAddress,
			CompanyContact companyContact) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.allDetails = details;
		this.allBillingAddress = billingAddress;
		this.allContactAddress = contactAddress;
		this.companyContact = companyContact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Address> getAllDetails() {
		return allDetails;
	}

	public void setAllDetails(List<Address> allDetails) {
		this.allDetails = allDetails;
	}

	public List<Address> getAllBillingAddress() {
		return allBillingAddress;
	}

	public void setAllBillingAddress(List<Address> allBillingAddress) {
		this.allBillingAddress = allBillingAddress;
	}

	public List<Address> getAllContactAddress() {
		return allContactAddress;
	}

	public void setAllContactAddress(List<Address> allContactAddress) {
		this.allContactAddress = allContactAddress;
	}

	public CompanyContact getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(CompanyContact companyContact) {
		this.companyContact = companyContact;
	}

	
	
	
}
