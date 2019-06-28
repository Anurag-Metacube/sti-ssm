package com.sti.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sti.ssm.dao.CompanyDao;
import com.sti.ssm.dto.CompanyDetailsDTO;
import com.sti.ssm.models.CompanyDetails;



@Service
public class CompanyService {
	
	@Autowired
	CompanyDao dao;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	ContactService contactService;
	
	private static final String CACHE_PREFIX = "company_service";
	
	public static String getCacheKey(String relevant){
		return CACHE_PREFIX + relevant;
	}
	
	public void addCompany(CompanyDetailsDTO companyDTO) {
		/*CompanyDetails company = new CompanyDetails();
		BeanUtils.copyProperties(companyDTO, company);*/
		/*ModelMapper modelMapper = new ModelMapper();
		CompanyDetails company = modelMapper.map(companyDTO, CompanyDetails.class);*/
		Gson gson = new Gson();
		CompanyDetails company = gson.fromJson(gson.toJson(companyDTO), CompanyDetails.class);
		dao.addCompany(company);
	}
	
	@Cacheable(cacheNames = "company", key = "T(com.sti.ssm.service.CompanyService).getCacheKey(#id)")
	public CompanyDetails getCompany (int id) {
		System.out.println("Inside getCompany by Id method()");
		return dao.getCompany(id);
	}
	
	@Cacheable(cacheNames = "company", key = "T(com.sti.ssm.service.CompanyService).getCacheKey('all')")
	public List<CompanyDetails> getAllCompanies(){
		System.out.println("Inside getAllCompanies method()");
		return dao.getAllCompanies();
	}

	public void deleteCompanyById(int id) {
		dao.deleteCompanyById(id);
		
	}
	
}
