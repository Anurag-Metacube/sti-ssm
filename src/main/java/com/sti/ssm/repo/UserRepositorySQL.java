package com.sti.ssm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sti.ssm.models.UserDetails;



@Repository
public interface UserRepositorySQL extends JpaRepository<UserDetails, Integer>{

	public void removeBySsn(int ssn);

}
