package com.demo.employees;

import com.demo.employees.domain.CompanyMapper;
import com.demo.employees.domain.CompanyMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public CompanyMapper companyMapper() {
        return new CompanyMapperImpl();
    }
}
