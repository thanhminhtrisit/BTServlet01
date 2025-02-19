package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConfig {
	// Database credentials
	private static final String JDBC_URL = "jdbc:mysql://localhost:3307/crm_app";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "se184190";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			// Establish the connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// Print an error message and stack trace
			System.out.println("Error connecting to the database!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection; // Return the connection object (could be null if failed)
	}
}
