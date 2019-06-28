package com.sti.ssm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sti.ssm.models.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{

	
	
}
