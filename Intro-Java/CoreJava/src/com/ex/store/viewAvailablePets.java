package com.ex.store;

import java.util.Scanner;

public class viewAvailablePets implements Screen{

	private Scanner scan = new Scanner(System.in);
	
	@Override
		public Screen start() {
		// most likely would be pulled from the database.
		System.out.println("Here's the pets: Sparky the Dog, Phillip the Fish");
		System.out.println("Please choose from the following options:");
			System.out.println("1 adopt a pet");
			System.out.println("2 play with pets");
			System.out.println("3 to go back to main menu");
			String input = scan.nextLine();

			switch (input) {
			case "1":
				System.out.println("Feature not yet implemented.");
				break;
			case "2":
				System.out.println("Bark bark! Blub Blub.");

				break;

			case "3":
				return new MainMenuScreen();
			}

			// TODO Auto-generated method stub
			return this;
	}

}
