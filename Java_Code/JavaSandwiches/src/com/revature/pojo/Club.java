package com.revature.pojo;

import com.revature.abstracts.Sandwich;

public class Club extends Sandwich{

	// state 
	private boolean isToasted;
	private int numberOfToothpicks;
	
	
	//no-arg is a must always for POJO
	public Club() {}
	
	// behavior
	
	
	
	@Override
	public int takeBite() {
		System.out.println("Taking a bite of a club");
		return this.size;
	}
	
	
	
	public Club(boolean isToasted, int numberOfToothpicks, int size) {
		super();
		this.isToasted = isToasted;
		this.numberOfToothpicks = numberOfToothpicks;
		this.size = size;
	}

	@Override
	public void prepping() {
		System.out.println("Club being made, will toast");
	}
}