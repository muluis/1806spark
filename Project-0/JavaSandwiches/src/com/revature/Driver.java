package com.revature;

import com.revature.pojo.Club;

//shortcut key for imports: command + shift + o



public class Driver {
	
	//Constructors: all classes have a constructor, they are NOT inherited

	public static void main(String[] args) {
		System.out.println("Going to create sandwiches...");
		
	//	Sandwich s = new Sandwich(); cannot instantiate a Sandwich since it is abstract
		
		Club c = new Club();
		c.setSlicesOfBread(-100);
		System.out.println(c.getSlicesOfBread() + " slices of bread");

	}

}