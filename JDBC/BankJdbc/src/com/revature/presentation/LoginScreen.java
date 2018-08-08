package com.revature.presentation;
/*
 * THIS IS THE LOGIN PAGE!
 * This is the login screen display where you enter your username and password
 */
import java.util.Scanner;

import com.revature.Screen;
import com.revature.businessLogic.BusinessLogic;
import com.revature.pojo.Users;

public class LoginScreen implements Screen {

	@SuppressWarnings("resource")
	@Override
	public Screen Start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("ENTER USERNAME");
		String userName = scan.nextLine();
		System.out.println("ENTER PASSWORD");
		String password = scan.nextLine();
		
		if(BusinessLogic.userExsists(userName, password)) {
			if(BusinessLogic.getUserAccount(Users.getCurrentUser().getUserId()))
			return new UsersMenuScreen(userName).Start();
		}
		System.out.println("LOGIN HAS FAILED");
		return this;
	}

}