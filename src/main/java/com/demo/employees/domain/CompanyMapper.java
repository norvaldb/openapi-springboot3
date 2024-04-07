package com.demo.employees.domain;

import org.mapstruct.Mapper;

@Mapper
public interface CompanyMapper {

    Company map(com.demo.employees.model.Company company);
    com.demo.employees.model.Company map(Company company);
}
