package com.project;

import java.io.IOException;
import java.util.Scanner;

import com.project.objs.*;

public class Navigation{
	
	public static void startMenu() {
		
		System.out.println("Interact with your blade.");
		System.out.println("1. Knife");
		System.out.println("2. Chainsaw");
		System.out.println("3. Create new blade");
	};
	public static void persistMenu() {
		
		System.out.println("Choose a blade:");
		System.out.println("1. Knife");
		System.out.println("2. Chainsaw");
		
			}
			
				
			
		

	
	public static Knife creatingNewKnife() throws IOException{
		System.out.println("Knife Creation Menu");
		
		System.out.println("Enter Name:");
		
		String knifeName = Scanner.nextLine();
		
		Cutter knife = new Knife();
		
		System.out.println(knife);
		scan.close();
		return knife;
		}
	
public static void knifeMenu() {
	
	System.out.println("Interact: Knife");
	System.out.println("1. Sharpen Knife");
	System.out.println("2. Slice");
	System.out.println("3. Return");
};



public static void chainSawMenu() {
	System.out.println("Select a Cutter");
	System.out.println("1. Sharpen");
	System.out.println("2. Change Blade.");
	System.out.println("3. Return");

/*switch (input) {
case "1":

case "2": 


case "3":
System.out.println("You cannot wield it.");
break;
}*/
};
}
