package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        // check the studentID again list size
        if ( (studentID >= theStudents.size()) || (studentID <0 )){
            throw new StudentNotFoundException("Student id not found - "  + studentID);
        }
        return theStudents.get(studentID);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundException exc) {

        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler ... to catch any exception ( catch all )
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
