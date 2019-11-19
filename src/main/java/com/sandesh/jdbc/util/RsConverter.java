package com.sandesh.jdbc.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sandesh.jdbc.models.Student;

public class RsConverter {

	public static List<Student> rsToStudents(ResultSet rs) throws SQLException {
		List<Student> students = new ArrayList<Student>();
		while (rs.next()) {
			students.add(new Student(
					rs.getInt("id"), rs.getString("name"),rs.getString("address"),rs.getString("gender")));
		}
		rs.close();
		return students;
	}
}
