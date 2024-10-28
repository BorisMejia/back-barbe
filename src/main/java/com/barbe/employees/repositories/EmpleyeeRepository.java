package com.barbe.employees.repositories;

import com.barbe.employees.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleyeeRepository extends JpaRepository<Employee, Long>
{

}
