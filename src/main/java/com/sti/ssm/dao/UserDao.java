package com.sti.ssm.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sti.ssm.models.UserDetails;
import com.sti.ssm.repo.UserRepositorySQL;



@Service
public class UserDao {
	
	@Autowired
	UserRepositorySQL repoSQL;
	/*@Autowired
	com.metacube.user.repo.oracle.UserRepositoryOracle repoOracle;*/
	
	@Transactional
	public void addUser(UserDetails user) {
		/*if(db.equalsIgnoreCase("mysql")) {
			repoSQL.save(user);
		}else {
			repoOracle.save(user);
		}*/
		repoSQL.save(user);
	}
	
	public UserDetails getUser(int ssn) {
		/*if(db.equalsIgnoreCase("mysql")) {
			return repoSQL.findById(ssn).get();
		}else {
			return repoOracle.findById(ssn).get();
		}*/
		return repoSQL.findById(ssn).get();
	}
	
	public List<UserDetails> getAllUsers(){
		/*if(db.equalsIgnoreCase("mysql")) {
			return repoSQL.findAll();
		}else {
			return repoOracle.findAll();
		}*/
		return repoSQL.findAll();
	}

	@Transactional
	public void deleteUserBySsn(int ssn) {
		/*if(db.equalsIgnoreCase("mysql")) {
			repoSQL.removeBySsn(ssn);
		}else {
			repoOracle.removeBySsn(ssn);
		}*/
		repoSQL.removeBySsn(ssn);
	}

}
