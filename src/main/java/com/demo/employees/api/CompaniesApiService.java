package com.demo.employees.api;


import com.demo.employees.facade.CompanyFacade;
import com.demo.employees.model.CompaniesResponse;
import com.demo.employees.model.Company;
import com.demo.employees.model.CompanyRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
        Company company = companyFacade.createCompany(companyRequest.getCompany().orElseThrow());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CompaniesResponse> listCompanies() {
        return new ResponseEntity<>(new CompaniesResponse().company(companyFacade.getCompanyList()),HttpStatus.OK);
    }
}
