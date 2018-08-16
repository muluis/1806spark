package com.advanced.threads;

import com.advanced.PizzaTime;
import com.advanced.drake.Chicago;
import com.advanced.drake.ThickCrust;

public class PizzaThread implements Runnable {

	@Override
	public void run() {
		
		if (PizzaTime.p == 1) {
			
			ThickCrust.promptForToppings();
			
		} else if (PizzaTime.p == 2) {

			Chicago.promptForToppings();
			
		} else System.out.println("Order error");
		
	}

}
