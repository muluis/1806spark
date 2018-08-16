package com.advanced;

import java.util.Scanner;

import com.advanced.drake.Chicago;
import com.advanced.drake.ThickCrust;
import com.advanced.presentation.UserMenuDisplay;
import com.advanced.threads.PizzaThread;

public class PizzaTime {
	
	public static int p;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		UserMenuDisplay.welcome();
		int userInput = 0;
		int choice = 0;
		
		while (true) {
			userInput = scan.nextInt();
			
			if (userInput == 1) {
//			switch (userInput) {
//			case 1:
				UserMenuDisplay.choosePizza();
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					p = 1;
					Runnable pt1 = new PizzaThread();
					Thread t1 = new Thread(pt1);
					t1.start();
					break;
				case 2:
					p = 2;
					Runnable pt2 = new PizzaThread();
					Thread t2 = new Thread(pt2);
					t2.start();
					break;
				}
				
//				break;
//			case 2:
			} else if (userInput == 2) {
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					ThickCrust.getPizzaOrder();
					break;
				case 2:
					Chicago.getPizzaOrder();
					break;
				default:
					System.out.println("please make an order");
					break;
				}
				
//				break;
//			case 3:
			} else if (userInput == 3) {
				System.out.println("Have a nice day!");
				scan.close();
				System.exit(1);
			}
		}
		
	}


}