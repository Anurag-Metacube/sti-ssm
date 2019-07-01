package com.sti.ssm.controller;

import com.sti.ssm.dto.CompanyDetailsDTO;
import com.sti.ssm.models.CompanyDetails;
import com.sti.ssm.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
public class CompanyController extends BaseController {
	
	@Autowired
	CompanyService companyService;
	
	@PostMapping(value="/company/add")
	public void addCompany(@RequestBody CompanyDetailsDTO company) {
        companyService.addCompany(company);
	}
	
	@GetMapping(value="/company/{id}")
	public CompanyDetails getCompany(@PathVariable int id) {
		log.info("Company Fetch Request for id : " + id);
		return companyService.getCompany(id);
	}
	
	@GetMapping(value="/companys")
	public List<CompanyDetails> getAllCompany() {
		return companyService.getAllCompanies();
	}
	
	@DeleteMapping(value="/company/{id}")
	public void deleteCompanyById(@PathVariable int id) {
		companyService.deleteCompanyById(id);
	}
}
