package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    /*
        Thanks to Spring REST and Jackson POJOs are authomatically converted to JSON
     */

    private List<Student> theStudents;

    // define @PostConstruct to laod the student data .. only once !!
    // this is MUCH better only load student data once
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Elon","Musk"));
        theStudents.add(new Student("Mario","Patel"));
        theStudents.add(new Student("Marry","Farop"));
    }

    // define endpoint "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
       return theStudents;
    }

    // define enpoint or "/studens/{studentID}" - return student ad index

    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID) {

        // just index into the list ... keet it simple for now
        return theStudents.get(studentID);
    }
}
