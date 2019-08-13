package com.sti.ssm.service;

import com.google.gson.Gson;
import com.sti.ssm.dao.CompanyDao;
import com.sti.ssm.dto.CompanyDetailsDTO;
import com.sti.ssm.models.CompanyDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CompanyService {
	
	@Autowired
	CompanyDao companyDao;
	
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
		companyDao.addCompany(company);
	}
	
	//@Cacheable(cacheNames = "company", key = "T(com.sti.ssm.service.CompanyService).getCacheKey(#id)")
	public CompanyDetails getCompany (int id) {
		log.debug("Inside getCompany by Id method()");
		return companyDao.getCompany(id);
	}
	
	//@Cacheable(cacheNames = "company", key = "T(com.sti.ssm.service.CompanyService).getCacheKey('all')")
	public List<CompanyDetails> getAllCompanies(){
		log.debug("Inside getAllCompanies method()");
		return companyDao.getAllCompanies();
	}

	public void deleteCompanyById(int id) {
		companyDao.deleteCompanyById(id);
		
	}
	
}
