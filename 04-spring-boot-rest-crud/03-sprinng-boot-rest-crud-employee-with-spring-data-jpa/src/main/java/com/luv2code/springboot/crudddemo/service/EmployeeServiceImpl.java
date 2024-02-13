package com.luv2code.springboot.crudddemo.service;

import com.luv2code.springboot.crudddemo.dao.EmployeeRepository;
import com.luv2code.springboot.crudddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
// Removes @Transactioanal since JpaRepository provides this functionality

import java.util.List;
import java.util.Optional;

@Service
    public class EmployeeServiceImpl implements EmployeeService{

    // set up constuctor injection
    private EmployeeRepository employeeRepository;

     @Autowired
     public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee=null;
        if (result.isPresent()){
            employee = result.get();
        }else{
            throw new RuntimeException("Did not found employee id - " + id);
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
