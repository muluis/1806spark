package com.advanced.drake;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

import com.advanced.presentation.UserMenuDisplay;

public class ThickCrust extends Pizza implements Serializable, OrderPizza {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1244090764218809531L;
	
	private static String filename = "src/com/advanced/pizzaBufferedCharacterFile.txt";
	
	private static Pizza pizza;

	public ThickCrust() {
		
		buildPizza();
		System.out.println("Thick crust chosen");
		isPlain = true;
		
	}
	
	public static void promptForToppings() {
		
		System.out.println("How many toppings?");
		boolean isMade = false;
		
		while (!isMade) {
			if (input >= 0) {
				switch (input) {
				case 0:
					pizza = new ThickCrust();
					break;
				default:
					pizza = new ThickCrustTop(input);
					break;
				}
				isMade = !isMade;
			} else System.out.println("must be non-negative amount of toppings");
		}
		
		writeCharacterStream(filename);
		
	}
	
	public static void getPizzaOrder() {
		
		readCharacterStream(filename);
		
	}

	
	private static void writeCharacterStream(String filename) {
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename));){
			
			writer.write(pizza.toString() + "\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void readCharacterStream(String filename){
		

		try(BufferedReader reader = new BufferedReader(new FileReader(filename));){
			
			String line = "";
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public String toString() {
		
		return "A thick crust pizza with " + pizza.numberOfToppings + " toppings";
		
	}
	
}