package com.ex.classes;

<<<<<<< HEAD
public class Dog extends Pet{
	
=======
public class Dog extends Pet {
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	private String breed;

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, int age, boolean isAlive, String breed) {
<<<<<<< HEAD
		super(name, age, isAlive);  // functionality that's being received
		this.breed = breed;
		// TODO Auto-generated constructor stub
=======
		super(name, age, isAlive);
		this.breed = breed;
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
<<<<<<< HEAD
	
=======

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	@Override
	public void speak() {
		System.out.println(this.getName() + " barks");
	}
<<<<<<< HEAD
	
=======

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
}
