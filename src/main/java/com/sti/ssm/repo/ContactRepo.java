package com.sti.ssm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sti.ssm.models.CompanyContact;

@Repository
public interface ContactRepo extends JpaRepository<CompanyContact, Integer>{

	
}
