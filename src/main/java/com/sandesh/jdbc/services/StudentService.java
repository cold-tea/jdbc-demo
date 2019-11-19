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

	public List<Student> getStudents() throws SQLException {
		Connection connection = DbUtil.getConnection();
		String query = "SELECT * FROM student";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return RsConverter.rsToStudents(rs);
	}
	
	public int addStudent(Student student) throws SQLException {
		Connection connection = DbUtil.getConnection();
		String query = "INSERT INTO student VALUES (?,?,?,?)";
		PreparedStatement prepStmt = connection.prepareStatement(query);
		prepStmt.setInt(1, student.getId());
		prepStmt.setString(2, student.getName());
		prepStmt.setString(3, student.getAddress());
		prepStmt.setString(4, student.getGender());
		return prepStmt.executeUpdate();
	}
}
