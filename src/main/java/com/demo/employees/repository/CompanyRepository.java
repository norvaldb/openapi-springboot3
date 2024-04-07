package com.demo.employees.repository;

import com.demo.employees.domain.Company;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Hidden
@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    Company findByOrganisationNumber(String organisationNumber);
}
