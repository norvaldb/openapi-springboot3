package com.demo.employees.facade;

import com.demo.employees.domain.CompanyMapper;
import com.demo.employees.model.Company;
import com.demo.employees.repository.CompanyRepository;
import com.demo.employees.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CompanyFacade {

    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;
    private final CompanyMapper companyMapper;

    public CompanyFacade(CompanyRepository companyRepository, EmployeeRepository employeeRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
        this.companyMapper = companyMapper;
    }

    public void createCompany(Company company) {
        com.demo.employees.domain.Company domainCompany = companyMapper.map(company);
        employeeRepository.saveAll(domainCompany.getEmployees());
        companyRepository.save(domainCompany);
    }

    public Company getCompany(String organisationNumber) {
        return Optional.ofNullable(companyMapper.map(companyRepository.findByOrganisationNumber(organisationNumber))).orElseThrow();
    }

    public List<Company> getCompanyList() {
        List<Company> companyList = new ArrayList<>();
        Iterable<com.demo.employees.domain.Company> all = companyRepository.findAll();
        all.forEach(c -> companyList.add(companyMapper.map(c)));
        return companyList;
    }

}
