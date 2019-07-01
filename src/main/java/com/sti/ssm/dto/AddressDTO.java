package com.sti.ssm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

	private int id;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String country;
	private String zip;
	
}
