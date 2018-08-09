package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.business.Service;
import com.revature.exceptions.OverdraftDetectedException;

public class WithdrawSeals implements Screen {

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many seals would you like to withdraw?");
		System.out.println("Amount: ");
		try {
			Double amount = scan.nextDouble();
			Service.withdrawSeals(amount);
		} catch (OverdraftDetectedException e) {
			System.out.println("In danger of singlehandedly causing seals to go extinct! Try being less greedy");
			System.out.println("                                                  ");
			return this.start();
		} catch (InputMismatchException e) {
			System.out.println("Numeric value required");
			return this.start();
		}

		return new MainMenu().start();
	}

}