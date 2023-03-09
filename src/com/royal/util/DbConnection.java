package com.royal.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnection 
{
	// 1) Make Credential
	public static final String URLNAME = "jdbc:mysql://localhost:3306/industrybatch";
	public static final String DRIVERCLASS = "com.mysql.cj.jdbc.Driver";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";
	// 2) create getDbConnection Method
	public static Connection getDbConnection() 
	{
		Connection conn = null;
		try 
		{
			// 3) Load Driver Class
			Class.forName(DRIVERCLASS);
			// 4) Pass Credential into DriverManager's getConnection Method
			conn = DriverManager.getConnection(URLNAME, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) 
	{
		DbConnection.getDbConnection();
	}
}
