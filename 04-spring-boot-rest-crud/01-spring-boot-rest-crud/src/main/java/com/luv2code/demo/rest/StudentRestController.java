package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
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


    // define endpoint "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> students = new ArrayList<>();

        students.add(new Student("Elon","Musk"));
        students.add(new Student("Mario","Patel"));
        students.add(new Student("Marry","Farop"));

       return students;
    }
}
