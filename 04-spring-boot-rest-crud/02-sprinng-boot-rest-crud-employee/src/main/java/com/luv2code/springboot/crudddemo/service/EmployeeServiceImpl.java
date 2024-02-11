package com.luv2code.springboot.crudddemo.service;

import com.luv2code.springboot.crudddemo.dao.EmployeeDAO;
import com.luv2code.springboot.crudddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    // set up constuctor injection
    private EmployeeDAO employeeDAO;

     @Autowired
     public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
