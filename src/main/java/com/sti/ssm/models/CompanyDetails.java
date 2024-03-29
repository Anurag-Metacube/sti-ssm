package com.sti.ssm.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "company_detail")
public class CompanyDetails implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	private String companyName;
	private String abbreviation;

	@OneToOne(cascade = {CascadeType.ALL})
	private Address details;

	@OneToOne(cascade = {CascadeType.ALL})
	private Address billingAddress;

	@OneToOne(cascade = {CascadeType.ALL})
	private Address contractAddress;

	@OneToOne(cascade = {CascadeType.ALL})
	private CompanyContact companyContact;
	
}
