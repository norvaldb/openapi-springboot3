package com.demo.employees.facade;

import com.demo.employees.domain.CompanyMapper;
import com.demo.employees.model.Company;
import com.demo.employees.repository.CompanyRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyFacade {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyFacade(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    public Company createCompany(Company company) {
        return companyMapper.map(companyRepository.save(companyMapper.map(company)));
    }

    public Company getCompany(long id) {
        return companyMapper.map(companyRepository.findById(id).orElseThrow());
    }

    public List<Company> getCompanyList() {
        return companyMapper.mapToModel(companyRepository.findAll());
    }

}
