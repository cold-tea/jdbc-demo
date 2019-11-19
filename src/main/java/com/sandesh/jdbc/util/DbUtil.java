package com.sandesh.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	// Embedded approach of connection
//	private final static String connectionString = "jdbc:h2:~/test";
	// Server approach of connection
	private final static String connectionString = "jdbc:h2:tcp://localhost/~/test";
	private final static String username = "sa";
	private final static String password = "";
	private static Connection connection = null;

	public static Connection getConnection() {
		
		try {
			Class.forName("org.h2.Driver");   
			connection =  DriverManager.getConnection(connectionString, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (connection == null) {
				System.out.println("Cannot receive a valid connection...");
				System.exit(0);
			}
		}
		return connection;
	}
}
