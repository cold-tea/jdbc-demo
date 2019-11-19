package com.sandesh.jdbc.main;

import java.sql.SQLException;

import com.sandesh.jdbc.models.Student;
import com.sandesh.jdbc.services.StudentService;

public class Main {
	
	private static StudentService stuService = new StudentService();

	public static void main(String[] args) throws SQLException {
		// Select students
		System.out.println(stuService.getStudents());
		
		// Insert student
		Student student = new Student(5, "Dummy Name", "Dummy Address", "M");
		System.out.println("Number of rows inserted: " + stuService.addStudent(student));
		
	}

}
