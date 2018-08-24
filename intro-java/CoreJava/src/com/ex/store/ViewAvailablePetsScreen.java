package com.ex.store;

import java.util.Scanner;

public class ViewAvailablePetsScreen implements Screen{
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		System.out.println("Here are the available pets");
		System.out.println("Please choose from the following options:");
		System.out.println("1 to adopt a pet");
		System.out.println("2 to play with pets");
		System.out.println("3 to go back to main menu");
		String input = scan.nextLine();

		switch (input) {
		case "1":
			System.out.println("feature not yet implemented");
			break;
		case "2":
			System.out.println("feature not yet implemented");
			break;
		case "3":
			return new InteractWithPetsScreen();
		}

		return this;
	}

}