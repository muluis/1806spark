package com.revature.abstracts;

import com.revature.exceptions.NoNegativeArgumentException;

/*
 * this is just general information
 * Sandwich class is going to be a template for creating
 * subclasses for specific sandwiches.
 * We are going to make this class abstract
 */
/**
 * Abstract keyword can be used in 2 locations: - classes - methods no such
 * thing as an abstract variable (javadocs comment w 2 asterisks) these comments
 * directly above mean it provides insight into the topic at hand.
 * 
 * subclass examples: - club -dagwood -cuban
 */
public abstract class Sandwich {

	// State aka variables below

	private int slicesOfBread; // not going to make protected because i can
	private String[] meats; // handle validation here for all of them using getters and setters.
	private String[] toppings;
	private String name;
	protected int size;
//	private boolean isToasted;
	// dont want to use cos cant guarantee all subclasses will use this

	// EVERY CLASS MUST HAVE A CONSTRUCTOR FROM THIS POINT ON.
	// no-args constructor, future frameworks will require this.

	// behaviors
	// public void prepping(); THIS WONT WORK BECAUSE IT ISNT ABSTRACT, NEEDS A
	// BODY.
	public abstract void prepping();

	// THIS IS OVERLOADING OF SANDWICH() AND SANDWICH(PARAMS)
	// OVERLOADING HAS TO OCCUR IN THE SAME CLASS.
	public Sandwich() {
	};

	public Sandwich(int slicesOfBread, String[] meats, String[] toppings, String name, int size) {
		super();
		this.slicesOfBread = slicesOfBread;
		this.meats = meats;
		this.toppings = toppings;
		this.name = name;
		this.size = size;
	}

	/**
	 * takeBite() decrements sandwich size by 1
	 * 
	 * @return remaining size of sandwich
	 */
	public int takeBite() {
		// this. is not required but there is no other size variable in the parameter or
		// the method
		// this. is ALWAYS in reference to the class-level.
		this.size--;
		return this.size;

	}

	public int takeBite(int biteSize) {
		this.size -= biteSize; // same as this.size - biteSize;
		return this.size;

	}
	
	
	/**
	 * setting property int slicesOfBread,
	 * do not pass a negative number as an argument, it will become zero.
	 * @param slicesOfBread 
	 */
	
	// creating a getter and setter for priv var slicesOfBread
	public int getSlicesOfBread() {
	return slicesOfBread;
	}							// you are shadowing the sandwich convention.
	public void setSlicesOfBread(int slicesOfBread) {
		if (slicesOfBread < 0) {
			this.slicesOfBread = 0;
			throw new NoNegativeArgumentException("Invalid! Cannot use less than 0 pieces of bread.");
			
	//System.out.println("Cannot have a negative value for slicesOfBread, setting to 0");
			
			//WITHOUT THIS ELSE STATEMENT YOU WOULD AUTOMATICALLY CALL THE IF AND THE THIS.SLICESOFBREAD.
		}else { 
		this.slicesOfBread = slicesOfBread;
		
	}
	}
}
