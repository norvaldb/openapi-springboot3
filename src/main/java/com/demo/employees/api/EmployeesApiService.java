package com.demo.employees.api;


import com.demo.employees.facade.EmpolyeeFacade;
import com.demo.employees.model.EmployeeRequest;
import com.demo.employees.model.EmployeeResponse;
import com.demo.employees.model.EmployeesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeesApiService implements EmployeesApiDelegate {

    private final EmpolyeeFacade empolyeeFacade;

    public EmployeesApiService(EmpolyeeFacade empolyeeFacade) {
        this.empolyeeFacade = empolyeeFacade;
    }

    @Override
    public ResponseEntity<Void> createEmployee(EmployeeRequest employeeRequest) {
        empolyeeFacade.createEmployee(employeeRequest.getEmpolyee().orElseThrow());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<EmployeeResponse> getEmployeeBySocialSecurityNumber(String socialSecurityNumber) {
        return new ResponseEntity<>(new EmployeeResponse().employee(empolyeeFacade.getEmployee(socialSecurityNumber)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EmployeesResponse> listEmployees() {
        return new ResponseEntity<>(new EmployeesResponse().employees(empolyeeFacade.getEmployeeList()), HttpStatus.OK);
    }
}
