package com.demo.employees.api;


import com.demo.employees.facade.CompanyFacade;
import com.demo.employees.model.CompaniesResponse;
import com.demo.employees.model.CompanyRequest;
import com.demo.employees.model.CompanyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompaniesApiService implements CompaniesApiDelegate {

    private final CompanyFacade companyFacade;

    public CompaniesApiService(CompanyFacade companyFacade) {
        this.companyFacade = companyFacade;
    }

    @Override
    public ResponseEntity<Void> createCompany(CompanyRequest companyRequest) {
        companyFacade.createCompany(companyRequest.getCompany().orElseThrow());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CompanyResponse> getCompanyByOrganisationNumber(String organisationNumber) {
        return new ResponseEntity<>(new CompanyResponse().company(companyFacade.getCompany(organisationNumber)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CompaniesResponse> listCompanies() {
        return new ResponseEntity<>(new CompaniesResponse().companies(companyFacade.getCompanyList()), HttpStatus.OK);
    }
}
