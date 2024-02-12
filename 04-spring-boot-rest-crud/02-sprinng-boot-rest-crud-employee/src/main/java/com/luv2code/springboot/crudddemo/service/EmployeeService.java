package com.luv2code.springboot.crudddemo.service;

import com.luv2code.springboot.crudddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    // Service Facade design pattern

    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
