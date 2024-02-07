package com.luv2code.demo.rest;

public class StudentNotFoundException extends RuntimeException{

    // Generate constructors from SuperClass

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
