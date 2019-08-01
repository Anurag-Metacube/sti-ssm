package com.sti.ssm.controller;

import com.sti.ssm.dto.CompanyDetailsDTO;
import com.sti.ssm.models.CompanyDetails;
import com.sti.ssm.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@EnableGlobalMethodSecurity(prePostEnabled=true)
//@CrossOrigin(origins = "*",allowCredentials = "true" , maxAge = 3600)
public class CompanyController extends BaseController {
	
	@Autowired
	CompanyService companyService;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping(value="/company/add")
	public void addCompany(@RequestBody CompanyDetailsDTO company) {
        companyService.addCompany(company);
	}
	
	//@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping(value="/company/{id}")
	public CompanyDetails getCompany(@PathVariable int id) {
		log.info("Company Fetch Request for id : " + id);
		return companyService.getCompany(id);
	}
	
	@GetMapping(value="/companys")
	public List<CompanyDetails> getAllCompany() {
		return companyService.getAllCompanies();
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@DeleteMapping(value="/company/{id}")
	public void deleteCompanyById(@PathVariable int id) {
		companyService.deleteCompanyById(id);
	}
	
	
}
