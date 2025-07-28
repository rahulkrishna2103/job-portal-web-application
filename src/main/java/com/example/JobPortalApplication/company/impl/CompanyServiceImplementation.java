package com.example.JobPortalApplication.company.impl;

import com.example.JobPortalApplication.company.Company;
import com.example.JobPortalApplication.company.CompanyRepository;
import com.example.JobPortalApplication.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplementation implements CompanyService {

    CompanyRepository companyRepository;

    public CompanyServiceImplementation(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }
    @Override
    public List<Company> findAllCompanies(){
        return companyRepository.findAll();
    }

    @Override
    public void addCompany(Company company){
        companyRepository.save(company);
    }

    @Override
    public Company findCompanyById(Long id){
        return companyRepository.findById(id).orElse(null);
    }
    @Override
    public boolean updateCompanyById(Long id, Company updatedcompany){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()){
            Company company = optionalCompany.get();
            company.setName(updatedcompany.getName());
            company.setDescription(updatedcompany.getDescription());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompanyById(Long id){
        try{
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }


}
