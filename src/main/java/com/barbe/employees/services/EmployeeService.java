package com.barbe.employees.services;

import com.barbe.employees.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService
{
    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    List<Employee> getEmployee();

    Optional<Employee> getEmployeeById(Long id);

    void deleteEmployee(Long id);

}
