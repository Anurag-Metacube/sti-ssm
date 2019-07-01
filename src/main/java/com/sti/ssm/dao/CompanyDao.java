package com.sti.ssm.dao;
import com.sti.ssm.models.CompanyDetails;
import com.sti.ssm.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyDao {

    @Autowired
    CompanyRepo repo;

    @Transactional
    public void addCompany(CompanyDetails company) {
        repo.save(company);
    }

    public CompanyDetails getCompany(int id) {
        return repo.findById(id).get();
    }

    public List<CompanyDetails> getAllCompanies(){
        return repo.findAll();
    }

    @Transactional
    public void deleteCompanyById(int id) {
        repo.deleteById(id);
    }

    public Boolean didCompanyExists(String name) {
        return repo.findByCompanyName(name) != null;
    }

    public CompanyDetails getCompanyByName(String name) {
        return repo.findByCompanyName(name) ;
    }

}
