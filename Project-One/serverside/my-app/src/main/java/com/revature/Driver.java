package com.revature;

import java.util.List;

import com.revature.logic.UserLogic;
import com.revature.pojo.TranstarUsers;

public class Driver {
	
	static String email = "yu@transtar.com";
	static String password = "mgr";

	public static void main(String[] args) {
		System.out.println("Testing transtar systems....");
		TranstarUsers user = new UserLogic().login(email, password);
		System.out.println("The user is: " + user);
		List<TranstarUsers> users = new UserLogic().getUsers();
		System.out.println(users);

	}

}
