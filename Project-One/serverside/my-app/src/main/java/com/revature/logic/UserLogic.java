package com.revature.logic;

import java.util.List;

import com.revature.dao.transtarUserDao;
import com.revature.pojo.TranstarUsers;

public class UserLogic {

	private transtarUserDao tuDao = new transtarUserDao();
	
	/**
	 * Compares parameters to the database. 
	 * @param email
	 * @param password
	 * @return user / null
	 */
	
	public TranstarUsers login(String email, String password) {
		TranstarUsers user = tuDao.getUser(email);
		if(user != null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	


	/**
	 * Retrieves all users in the database.
	 * @return List<TranstarUsers> users / null
	 */
	public List<TranstarUsers> getUsers() {
		List<TranstarUsers> users = tuDao.readUsers();
		if(users != null) {
			return users;
		}
		
		return null;
		
	}
	
}