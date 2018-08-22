package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SetConnectionPropertiesUtil {
	
	/*
	 * utility class helper methods not specified to manipulation of pojos
	 * 		as that would be business logic in services
	 * usually for configuration
	 */

	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String username = "todo_db";
		String password = "p4ssw0rd";
		String url = "jdbc:oracle:thin:@octowolf.crtsillkaxup.us-east-2.rds.amazonaws.com:1521:ORCL";
		
//		Properties props = new Properties();
//		props.load(new FileReader("C:\\Users\\eddie_000\\my_git-repos\\1806spark\\JDBC\\TodoList\\src\\main\\resources\\db.properties"));
//		url = props.getProperty("url");
//		username = props.getProperty("username");
//		password = props.getProperty("pw");
		
		return DriverManager.getConnection(url, username, password);	
	}
}
