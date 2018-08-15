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
	 * 	utility class helper methods not specific to manipulation of pojos
	 * 		as that would be business logic in services
	 * 	usually for configuration
	 */
	//	let the developer that needs a connection handle these exceptions
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //required for Tomcat
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String username = "todo_db";
		String password = "p4ssw0rd";
		String url = "jdbc:oracle:thin:@hearthstone.cxazmpz2rlnm.us-east-2.rds.amazonaws.com:1521:ORCL";
		
//		Properties props = new Properties();
//		props.load(new FileReader("src\\main\\resources\\db.properties"));
		
//		url = props.getProperty("url");
//		username = props.getProperty("username");
//		password = props.getProperty("password");
		
		return DriverManager.getConnection(url, username, password);
	}

}
