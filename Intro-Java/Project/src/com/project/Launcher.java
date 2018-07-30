package com.project;

import java.io.IOException;
import java.util.Scanner;
import com.project.dao.Dao;
import com.project.objs.Knife;

public class Launcher {

	public static void main(String[] args) throws IOException{
		while(true) {
		
		Scanner scan = new Scanner(System.in);
		Navigation.startMenu();
		int key = scan.nextInt();
		
		switch (key) {
		case 1:
			System.out.println("Knife chosen.");
			getKnife();
			
			break;
		case 2:
			System.out.println("Chainsaw chosen.");
			//getChainSaw();
			break;
		case 3:
			System.out.println("Creating new blade.");
			getNew();
			scan.close();
			break;
		}
		}
	}
	
	
	
	
	
	public static void getNew() throws IOException{
	Navigation.persistMenu();
	Scanner scan = new Scanner(System.in);
	int userInput = scan.nextInt();
	switch (userInput) {
	case 1:
		Knife knife = Navigation.creatingNewKnife();
	try{
		Dao.serializeBlade(knife);
	}catch (IOException e) {
	
}

	scan.close();
		break;
	case 2: scan.close();
		Navigation.creatingNewKnife();
		break;
	
	}
	}
	
	public static void getKnife() {
	Navigation.knifeMenu();
	Scanner scan = new Scanner(System.in);
	int userInput = scan.nextInt();
	switch (userInput) {
	case 1:
		System.out.println("You sharpen your knife.");
		getKnife();
			scan.close();
			
		break;
	case 2: System.out.println("You slice some bread");
	getKnife();
	scan.close();
		break;
	}
	
	
	/*try{Dao.deserializeBlade(cutter);
	
	}catch (Exception e) {
		System.out.println("File could not transfer.");};
	}
	public static void getChainSaw() {
		Navigation.chainSawMenu();
	}*/
	}}
	 