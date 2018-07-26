package com.ex.store;

import java.util.Scanner;

public class MainMenuScreen implements Screen {
	// Scanner is used to take in user input
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
			return new InteractWithPetScreen();
		case "2":
			return new ViewAvaliablePetsScreen();
			
		case "3":
			System.out.println("feature not yet implemented");
			break;
		}
		
		return this;
		
	}
	
	

}
