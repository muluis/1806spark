package com.advanced.drake;

import java.io.IOException;
import java.io.Serializable;

import com.advanced.dao.PizzaDao;
import com.advanced.presentation.UserMenuDisplay;

public class Chicago extends Pizza implements Serializable, OrderPizza {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5253514272229266229L;

	public Chicago() {
		
		buildPizza();
		System.out.println("Chicago style chosen");
		isPlain = true;
		
	}
	
	public static void promptForToppings() {

		System.out.println("How many toppings?");
		boolean isMade = false;
		Pizza pizza = null;
		
		while (!isMade) {
			if (input >= 0) {
				switch (input) {
				case 0:
					pizza = new Chicago();
					break;
				default:
					pizza = new ChicagoTop(input);
					break;
				}
				isMade = !isMade;
			} else System.out.println("must be non-negative amount of toppings");
		}
		
		// Persist pizza to order file
		try {
			PizzaDao.serializePizza(pizza);
		} catch (IOException e) {
			System.out.println("Order malfunction");
		}
		
	}
	
	public static void getPizzaOrder() {
		
		// retrieve pizza via PizzaDao
		Chicago pizza = null;
		try {
			pizza = (Chicago) PizzaDao.deserializePizza();
		} catch (ClassNotFoundException e) {
			System.out.println("Choice not found");
		} catch (IOException e) {
			System.out.println("Order malfunction");
		}
		
		UserMenuDisplay.currentOrder(pizza);
		
	}

}