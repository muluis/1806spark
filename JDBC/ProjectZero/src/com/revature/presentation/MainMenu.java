package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.businesslogic.Service;
import com.revature.interfaces.Screen;
import com.revature.pojo.BankAccount;
import com.revature.pojo.User;

public class MainMenu implements Screen {
	
	@Override
	public Screen start() {
		
		Scanner scan = new Scanner(System.in);
		
		User currentUser = User.getCurrentUser();
		
		System.out.println("Welcome! " + currentUser.getFirstName() + " " + currentUser.getLastName());
		Service.applyUserAccount(currentUser.getUserId());
		System.out.println(BankAccount.getCurrentAccount());
		
		System.out.println("What would you like to do?");
		System.out.println("1: Make a deposit");
		System.out.println("2: Withdrawal");
		System.out.println("3: View past transactions");
		System.out.println("4: Logout");
		System.out.println("5: Exit program");
		
		try {
			int userInput = scan.nextInt();
		
			switch (userInput) {
				case 1:
					return new Deposit().start();
				case 2:
					return new Withdrawal().start();
				case 3:
					return new ViewTx().start();
				case 4:
					System.out.println("User is logging out...");
					return new Login().start();
				case 5:
					System.out.println("Exiting program...");
					System.exit(1);
				}
		} catch (InputMismatchException e) {
			System.out.println("Please choose from the choices below");
		}
		
		
		
		return this.start();
		
	}

}