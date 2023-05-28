package com.asnluv2code.cruddemo;

import com.asnluv2code.cruddemo.dao.StudentDAO;
import com.asnluv2code.cruddemo.entity.Student;
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

	/*
	@Bean
	CommandLineRunner commandLineRunner(String[] args){

		return runner ->{
			System.out.println("Hello world");
		};

	 */


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

            //queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleting row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting Student Id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);

		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating Student ....");

		myStudent.setFirstName("Scooby");

		studentDAO.update(myStudent);

		System.out.println("Updated Student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findByLastName("Doe");
        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO){
		List<Student> theStudents = studentDAO.findAll();
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating the student...");
		Student tempStudent4 = new Student("Shiv","anand","as@luv2code.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent4);

		int theId = tempStudent4.getId();
		System.out.println("Saved student. Generated id: " + theId);

		System.out.println("Retriving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("Jhon", "Doe", "jhon@luv2code.com");
		Student tempStudent2 = new Student("Anand", "Shekhar", "asn@luv2code.com");
		Student tempStudent3 = new Student("Rahul", "Maurya", "rm@luv2code.com");

		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}


	private void createStudent(StudentDAO studentDAO) {
    System.out.println("Creating new Student object....");
	Student tempStudent = new Student("paul","Doe","paul@luv2code.com");

	System.out.println("Saving the student...");
	studentDAO.save(tempStudent);

	System.out.println("Saved student. Generated id: " +  tempStudent.getId());
	}

}
