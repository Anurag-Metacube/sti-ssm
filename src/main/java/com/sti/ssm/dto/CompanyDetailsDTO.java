package com.sti.ssm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDetailsDTO {

    private int id;
    private String companyName;
    private String abbreviation;
    private AddressDTO details;
    private AddressDTO billingAddress;
    private AddressDTO contractAddress;
    private CompanyContactDTO companyContact;

}