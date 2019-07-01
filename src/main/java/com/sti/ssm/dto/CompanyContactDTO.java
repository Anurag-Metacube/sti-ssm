package com.sti.ssm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyContactDTO {

	private int id;
	private String firstName;
	private String lastName;
	private String emailId;
	private AddressDTO contactAddress;
	
}
