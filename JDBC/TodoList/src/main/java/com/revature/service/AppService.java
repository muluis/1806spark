package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class AppService {

	/*
	 * 	business logic like login validation
	 * 		validate models before persisting
	 * 		manipulate models before persisting
	 * 		validate user before pulling sensitive data 
	 * 		etc...
	 */
	
	private UserDao userDao = new UserDaoImpl();
	
	// return a valid user object or return null;
	public User login(User userInput) {
		System.out.println("[LOG]----Starting---Service login() argument: " + userInput);
		// First pass the userInput's username to the dao to see if there is a 
		// 		is a record found in the database with that username
		//		Yes - assign the user record to a User java object
		// 		No - then it is null
		System.out.println("[LOG]----calling dao---Service login()");
		User dbUser = userDao.getUserByUsername(userInput.getUsername());
		System.out.println("[LOG]----dao returned---Service login() returned: " + dbUser);

		// Since the username might n ot be found I could get null back... Check for that!
		if(dbUser != null) {
			System.out.println("[LOG]----dbUser null check---Service login() status: successful");
			// now let's compare the userInput's pass to the dbUser's password
			if(dbUser.getPassword().equals(userInput.getPassword())) {
				System.out.println("[LOG]----compare pw---Service login() pw: success");
				return dbUser; // not userInput since it doesn't have the userId
			}
			
		}
		System.out.println("[LOG]----ending--Service login() pw: fail");
		return null;
	}
}
