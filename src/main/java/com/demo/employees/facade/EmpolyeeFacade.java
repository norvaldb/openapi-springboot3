package com.demo.employees.facade;

import com.demo.employees.domain.EmployeeMapper;
import com.demo.employees.model.Employee;
import com.demo.employees.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmpolyeeFacade {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmpolyeeFacade(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public void createEmployee(Employee employee) {
        employeeMapper.map(employeeRepository.save(employeeMapper.map(employee)));
    }

    public Employee getEmployee(String socialSecurityNumber) {
        return Optional.ofNullable(employeeMapper.map(employeeRepository.findBySocialSecurityNumber(socialSecurityNumber))).orElseThrow();
    }

    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        Iterable<com.demo.employees.domain.Employee> all = employeeRepository.findAll();
        all.forEach(employee -> employeeList.add(employeeMapper.map(employee)));
        return employeeList;
    }

}
