package com.sandesh.jdbc.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.sandesh.jdbc.models.Student;
import com.sandesh.jdbc.util.DbUtil;
import com.sandesh.jdbc.util.RsConverter;

public class StudentService {

	public List<Student> getStudents(){
		try(Connection connection = DbUtil.getConnection();
				Statement stmt = connection.createStatement();) {
			String query = "SELECT * FROM student";
			ResultSet rs = stmt.executeQuery(query);
			return RsConverter.rsToStudents(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer addStudent(Student student) { 
		String query = "INSERT INTO student VALUES (?,?,?,?)";
		try(Connection connection = DbUtil.getConnection();
				PreparedStatement prepStmt = connection.prepareStatement(query);) {
			
			prepStmt.setInt(1, student.getId());
			prepStmt.setString(2, student.getName());
			prepStmt.setString(3, student.getAddress());
			prepStmt.setString(4, student.getGender());
			return prepStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
}
