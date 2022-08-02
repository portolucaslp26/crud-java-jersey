package com.courses.factory;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root123";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/courses";
	
	public static Connection getConnection( ) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return conn;
	}
	
	public static void main (String[] args) throws Exception {
		Connection con = getConnection();
		
		if(con !=null) {
			System.out.println("Connection Success");
			con.close();
		}
	}
}

