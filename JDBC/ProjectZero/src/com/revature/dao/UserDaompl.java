package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.User;

public class UserDaompl implements UserDao {
	
	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@hearthstone.cxazmpz2rlnm.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	@Override
	public int createUser(User u) {
		return 0;
	}
	
	@Override
	public void createUserProc(User u) {
		
	}
	
	@Override
	public List<User> readUser() {
		
		List<User> users = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getInt(1), rs.getString(4), rs.getString(5), rs.getString(2), rs.getString(3)); 
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public User getUserById(int id) {
		return null;
	}

	@Override
	public int updateUser(User u) {
		return 0;
	}

}
