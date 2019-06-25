package com.sti.ssm.models;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserDetails {

	@Id
	int ssn;
	
	String name;
	String emailId;
	String company;
	
	public UserDetails() {}
	
	public UserDetails(int ssn, String name, String emailId, String company) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.emailId = emailId;
		this.company = company;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		return  "Name:"+this.getName()+"-SSN:"+this.getSsn()+"-Email:"+this.getEmailId()+"-Company:"+this.getCompany();
	}
	
}
