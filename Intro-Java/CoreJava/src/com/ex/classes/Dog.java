package com.ex.classes;

public class Dog extends pet{
	
	private String breed;

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, int age, boolean isAlive, String breed) {
		super(name, age, isAlive);
		// TODO Auto-generated constructor stub
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public void speak() {
	 System.out.println(this.getName() + " woof!");
		// TODO Auto-generated method stub
		
	}


}
