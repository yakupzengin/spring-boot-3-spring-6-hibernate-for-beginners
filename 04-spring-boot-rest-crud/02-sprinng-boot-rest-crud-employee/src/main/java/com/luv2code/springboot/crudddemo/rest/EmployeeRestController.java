package com.luv2code.springboot.crudddemo.rest;

import com.luv2code.springboot.crudddemo.entity.Employee;
import com.luv2code.springboot.crudddemo.service.EmployeeService;
import com.luv2code.springboot.crudddemo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // quick and dirty: inject employee dao ( use constructor injection )
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll () {
        return employeeService.findAll();
    }

    // add mapping for GET /employee/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }
        return theEmployee;
    }

    // add mapping for POST / employee - add new employee

    @PostMapping("/employees")
    public Employee addEmpployee(@RequestBody Employee theEmployee){

        // also just in case they pass an id in JSON .. set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

}
