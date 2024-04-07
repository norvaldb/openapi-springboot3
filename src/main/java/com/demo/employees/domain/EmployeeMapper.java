package com.demo.employees.domain;

import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {
    Employee map(com.demo.employees.model.Employee employee);
    com.demo.employees.model.Employee map(Employee employee);
}
