package com.example.JobPortalApplication.company;


import java.util.List;

public interface CompanyService {
    List<Company> findAllCompanies();
    void addCompany(Company company);
    Company findCompanyById(Long id);
    boolean updateCompanyById(Long id,Company company);
    boolean deleteCompanyById(Long id);

}
