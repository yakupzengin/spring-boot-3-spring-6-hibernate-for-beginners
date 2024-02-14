package com.luv2code.springboot.crudddemo.dao;

import com.luv2code.springboot.crudddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Entity type : Employee
    // Primary Key : Integer

    // that is it ... no need to write any code
}
