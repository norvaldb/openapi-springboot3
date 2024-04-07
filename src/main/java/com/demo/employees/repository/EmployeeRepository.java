package com.demo.employees.repository;

import com.demo.employees.domain.Employee;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Hidden
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee findBySocialSecurityNumber(String socialSecurityNumber);
}
