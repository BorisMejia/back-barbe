package com.barbe.employees.services;

import com.barbe.employees.entities.Employee;
import com.barbe.employees.repositories.EmpleyeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void addEarnings(Employee employee, Double amount) 
    {
        employee.addPayment(amount);
        empleyeeRepository.save(employee);
    }
@Override
    public void resetDailyEarnings(Employee employee)
    {
        employee.setPayments(new ArrayList<>());
        empleyeeRepository.save(employee);
    }


}
