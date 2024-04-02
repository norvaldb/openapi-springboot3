package com.demo.employees.repository;

import com.demo.employees.domain.Company;
import com.demo.employees.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
