package com.sti.ssm.controller;

import com.sti.ssm.dto.CompanyDetailsDTO;
import com.sti.ssm.models.CompanyDetails;
import com.sti.ssm.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class CompanyController extends BaseController {
	
	@Autowired
	CompanyService companyService;
	
	@PreAuthorize("hasRole('admin')")
	@PostMapping(value="/company/add")
	public void addCompany(@RequestBody CompanyDetailsDTO company) {
        companyService.addCompany(company);
	}
	
	@PreAuthorize("hasRole('user')")
	@GetMapping(value="/company/{id}")
	public CompanyDetails getCompany(@PathVariable int id) {
		log.info("Company Fetch Request for id : " + id);
		return companyService.getCompany(id);
	}
	
	@PreAuthorize("hasRole('user') or hasRole('editor')")
	@GetMapping(value="/companys")
	public List<CompanyDetails> getAllCompany() {
		return companyService.getAllCompanies();
	}
	
	@PreAuthorize("hasRole('admin')")
	@DeleteMapping(value="/company/{id}")
	public void deleteCompanyById(@PathVariable int id) {
		companyService.deleteCompanyById(id);
	}
}
