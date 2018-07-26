package com.revature;

import com.revature.pojo.Club;

// shortcut key for imports: ctrl + shirft + o

public class Driver {

	/*
	 * Constructors: all classes have a constructor, they are not inherited
	 */

	public static void main(String[] args) {
		System.out.println("Going to create sandwiches");

//			Sandwiches s = new Sandwiches(); cannot instantiate a Sandwich since it's abstract!
		Club c = new Club();

		int userInput = -100;
		if (userInput >= 0) {
			c.setSlicesOfBread(userInput);
		}
		System.out.println(c.getSlicesOfBread());
	}
}