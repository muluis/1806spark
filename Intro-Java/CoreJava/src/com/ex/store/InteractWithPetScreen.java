package com.ex.store;

import java.util.Scanner;

public class InteractWithPetScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	
	@Override
	public Screen start() {
		System.out.println("Please choose from the following options: ");
		System.out.println("1 to interact with your pets"); 
		System.out.println("2 to play pets ");
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
			return new MainMenuScreen();
		}
		
		return this;
	}

	
	
	
	
	
	
}
