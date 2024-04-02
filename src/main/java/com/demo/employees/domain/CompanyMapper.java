package com.demo.employees.domain;

import com.demo.employees.repository.CompanyRepository;
import org.mapstruct.Mapper;

@Mapper
public abstract class CompanyMapper extends AbstractGenericMapper<Company, com.demo.employees.model.Company> {

    protected CompanyMapper(CompanyRepository companyRepository) {
        super(companyRepository);
    }

    protected Company newInstance() {
        return new Company();
    }

}
