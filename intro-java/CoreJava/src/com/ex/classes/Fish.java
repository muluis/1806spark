package com.ex.classes;

public class Fish extends Pet{
	private int fins;
	
	public Fish() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fish(String name, int age, boolean isAlive, int fins) {
		super(name, age, isAlive);
		this.fins=fins;
		// TODO Auto-generated constructor stub
	}

	public int getFins() {
		return fins;
	}

	public void setFins(int fins) {
		this.fins = fins;
	}

	@Override
	public void speak() {
		System.out.println(this.getName() + " bubbles");
	}
}