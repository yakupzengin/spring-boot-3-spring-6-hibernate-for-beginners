package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudent(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int id = 1;
		System.out.println("Getting student with id : " + id);
		Student student = studentDAO.findById(id);

		// change first name to "Scooby"
		System.out.println("Updating ... ");
		student.setFirstName("Scooby");

		// update the student
		studentDAO.update(student);

		// display the updated student
		System.out.println("Updated student : "+student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents  = studentDAO.findByLastName("Duck");

		// display list of students
		for (Student tempStudents : theStudents){
			System.out.println(tempStudents);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of the students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object ...");
		Student student = new Student("Daffy","Duck","daffy@gmail.com");

		// save the student
		studentDAO.save(student);

		// display id of the saved students
		int theID = student.getId();
		System.out.println("Saved student ID : " + theID);

		// retrive student based on the id : primary key
		System.out.println("Retrieving student with id : "+ theID);
		Student tempStudent = studentDAO.findById(theID);

		// display the student
		System.out.println("Found the student : " + tempStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating new students object ... ");
		Student tempStudent1 = new Student("Yakup","Zengin","yakupzengin0@outlook.com.tr");
		Student tempStudent2 = new Student("Paul","George","paulgeorge@outlook.com");
		Student tempStudent3 = new Student("Irem","Yapan","iremyapan1999@gmail.com");

		// save the students object
		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		System.out.println("It's done. ");
	}

	private void createStudent(StudentDAO studentDAO) {

		// create student object
		System.out.println("Creating new student object ... ");
		Student tempStudent = new Student("Yakup","Zengin","yakupzengin0@outlook.com.tr");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated ID: " + tempStudent.getId());
	}

}
