package com.barbe.employees.controllers;

import com.barbe.employees.entities.Employee;
import com.barbe.employees.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
    {
        try {
            Employee saveeEmployee = employeeServiceImpl.saveEmployee(employee);
            return new ResponseEntity<>(saveeEmployee, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/{id}/addEarnings")
    public void addEarnings(@PathVariable Long id, @RequestParam Double amount) {
        Optional<Employee> employee = employeeServiceImpl.getEmployeeById(id);
        employee.ifPresent(emp -> employeeServiceImpl.addEarnings(emp, amount));
    }
    @PostMapping("/{id}/resetDailyEarnings")
    public void resetDailyEarnings(@PathVariable Long id) {
        Optional<Employee> employee = employeeServiceImpl.getEmployeeById(id);
        employee.ifPresent(employeeServiceImpl::resetDailyEarnings);
    }
    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
    {
        try {
            Employee updateeEmployee = employeeServiceImpl.updateEmployee(employee);
            return new ResponseEntity<>(updateeEmployee, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        return new ResponseEntity<>(employeeServiceImpl.getEmployee(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)
    {
        Optional<Employee> employee = employeeServiceImpl.getEmployeeById(id);
        if (employee.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(employee.get(),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id)
    {
        Optional<Employee> employee = employeeServiceImpl.getEmployeeById(id);
        if (employee.isPresent())
        {
            employeeServiceImpl.deleteEmployee(employee.get().getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
