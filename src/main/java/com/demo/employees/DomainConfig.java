package com.demo.employees;

import com.demo.employees.domain.CompanyMapper;
import com.demo.employees.domain.CompanyMapperImpl;
import com.demo.employees.domain.EmployeeMapper;
import com.demo.employees.domain.EmployeeMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public CompanyMapper companyMapper() {
        return new CompanyMapperImpl();
    }
    @Bean
    public EmployeeMapper employeeMapper() {
        return new EmployeeMapperImpl();
    }
}
