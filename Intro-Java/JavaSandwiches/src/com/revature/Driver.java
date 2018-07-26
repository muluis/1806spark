package com.revature;

import com.revature.abstracts.Sandwich;
import com.revature.pojo.Club;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Going to create sandwiches!");
		
		// CONSTRUCTORS 
		
//		Sandwich s = new Sandwich(); //cannot instantiate a sandwich since it is an abstract.

		Club c = new Club();
		// c.slicesOfBread = 10; // cannot do this because it is trying to pull from a private.
		int userInput = 100; 
		
		Club d = new Club();
		//if(userInput >= 0) {
			c.setSlicesOfBread(userInput);
		//}
		System.out.println(c.getSlicesOfBread());
	}

}
