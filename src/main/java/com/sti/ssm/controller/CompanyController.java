package com.sti.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sti.ssm.models.CompanyDetails;
import com.sti.ssm.dto.CompanyDetailsDTO;
import com.sti.ssm.service.CompanyService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CompanyController {
	
	@Autowired
	CompanyService service;
	
	@RequestMapping(method=RequestMethod.POST, value="/company/add")
	public void addCompany(@RequestBody CompanyDetailsDTO company) {
		service.addCompany(company);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/company/{id}")
	public CompanyDetails getCompany(@PathVariable int id) {
		return service.getCompany(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/companys")
	public List<CompanyDetails> getAllCompany() {
		return service.getAllCompanies();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/company/{id}")
	public void deleteCompanyById(@PathVariable int id) {
		service.deleteCompanyById(id);
	}
}
