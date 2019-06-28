package com.sti.ssm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sti.ssm.dao.CompanyDao;
import com.sti.ssm.dto.CompanyDetailsDTO;
import com.sti.ssm.models.Address;
import com.sti.ssm.models.CompanyContact;
import com.sti.ssm.models.CompanyDetails;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;



@Service
public class CompanyService {
	
	@Autowired
	CompanyDao dao;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	ContactService contactService;
	
	public void addCompany(CompanyDetailsDTO companyDTO) {
		/*CompanyDetails company = new CompanyDetails();
		BeanUtils.copyProperties(companyDTO, company);*/
		/*ModelMapper modelMapper = new ModelMapper();
		CompanyDetails company = modelMapper.map(companyDTO, CompanyDetails.class);*/
		Gson gson = new Gson();
		CompanyDetails company = gson.fromJson(gson.toJson(companyDTO), CompanyDetails.class);
		dao.addCompany(company);
	}
	
	public CompanyDetails getCompany (int id) {
		return dao.getCompany(id);
	}
	
	public List<CompanyDetails> getAllCompanies(){
		return dao.getAllCompanies();
	}

	public void deleteCompanyById(int id) {
		dao.deleteCompanyById(id);
		
	}
	
}
