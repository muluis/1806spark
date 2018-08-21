package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.pojo.User;

public class UserService {

	private UserDao userDao = new UserDaoImpl();
	
	
	public User validateManagerLogin(String email, String password) {
		
		User user = userDao.getUserByEmail(email);
		if(userDao.getUserByEmail(email) != null) {
			if (user.getPassword().equals(password)) {
				return user; 
			}
		} 
		return null;
	}
	
	public void updateEmployeeInfo(int uId, String email, String pw, String fname, String lname) {
		// enter logic to check user validation
		if (userDao.getUserByEmail(email).getPos_id() == 1) {
			userDao.updateEmployee(uId, pw, fname, lname);
		}
	}
}