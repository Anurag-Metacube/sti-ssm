package com.sti.ssm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sti.ssm.models.CompanyDetails;



@Repository
public interface CompanyRepo extends JpaRepository<CompanyDetails, Integer>{

		public CompanyDetails findByCompanyName(String name);
}
