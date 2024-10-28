package com.barbe.employees.services;

import com.barbe.employees.entities.Employee;
import com.barbe.employees.repositories.EmpleyeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

    @Autowired
    EmpleyeeRepository empleyeeRepository;

    @Override
    public Employee saveEmployee(Employee employee)
    {
        return empleyeeRepository.save(employee);
    }
    @Override
    public Employee updateEmployee(Employee employee)
    {
        return empleyeeRepository.save(employee);
    }
    @Override
    public List<Employee> getEmployee()
    {
        return empleyeeRepository.findAll();
    }
    @Override
    public Optional<Employee> getEmployeeById(Long id)
    {
        return empleyeeRepository.findById(id);
    }
    @Override
    public void deleteEmployee(Long id)
    {
        empleyeeRepository.deleteById(id);
    }
    @Override
    public void addEarnings(Employee employee, Double amount) {
        if (amount != null && amount > 0) employee.setDailyEarnings(employee.getDailyEarnings() + amount);
    }
    @Override
    public void resetDailyEarnings(Employee employee) {
        employee.setDailyEarnings(0.0);
    }


}
