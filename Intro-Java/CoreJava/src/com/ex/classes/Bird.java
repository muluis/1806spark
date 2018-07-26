package com.ex.classes;

public class Bird extends Pet {
	private int color;

	public Bird() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bird(String name, int age, boolean isAlive, int color) {
		super(name, age, isAlive);
		this.color = color;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public void speak() {
		System.out.println(this.getName() + " bubbles");
	}
	
	

}