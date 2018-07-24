package com.revature;

<<<<<<< HEAD
//POJO - Plain Old Java Object
//no entry point but has state and behavior 
public class Person {

	//public and private access modifier
		//public: any developer can see it
		//private: only reference privte variables or methods from inside the same class
	
	// state: variables
=======
// POJO: plain old java object aka no entry point but has state/behavior
public class Person extends Object{

	/*
	 * 	public and private access modifier
	 * 		public: any developer can see it
	 * 		private: only reference private variables or methods from inside the same class
	 */
	
	// state: variables at the instance level scope (not static and not nested in a method)
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
	public String name;
	public int age;
	public double height;
	public boolean isAlive;
	public char gender;
<<<<<<< HEAD
	
	//create a constructor: takes in the values to set the object's state
	//	constructor follow very strict syntax
	//		no return type, it returns the object
	//		the name is the same as the class
	public Person() {
		System.out.println("making a person object");
	}
	
	public Person(String name, int age, double height, Boolean isAlive, char gender) {
=======

	
	// create a constructor: the constructor takes in the values to set the object's state
	// 		constructor follow very strict syntax
	//			- no return type, it returns the object
	//			- the name is the same as the class
	//			- can have any access modifier
	public Person(){
		System.out.println("making a person object");
	}
					// when method/constructor parameter have the same name as the instance variables: shadowing
	public Person(String name, int age, double height, boolean isAlive, char gender){
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
		this.name = name;
		this.age = age;
		this.height = height;
		this.isAlive = isAlive;
		this.gender = gender;
<<<<<<< HEAD
		System.out.println("making a person object");
	}
	
	//Method overloading constructors w/ same name but different parameters inside the same class IQ
	//create a constructor w/ name, age, type
	
	public Person(String name, int age, double height) {
		super();//first line of every constructor is super() by default!
=======
		System.out.println("making a person object w/ parameters");
	}
	/*
	 * 	constructors/methods with the same name but different parameters inside the same class: overloading IQ
	 */
	//Create a constructor with only name, age, height
	public Person(String name, int age, double height) {
		super(); // the first line of every constructor is super() by DEFAULT!!
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
		this.name = name;
		this.age = age;
		this.height = height;
	}
<<<<<<< HEAD
=======
	
	
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
	// behavior: methods
	public void walk() {
		System.out.println("I am walking");
	}

<<<<<<< HEAD
	//method overriding: changing the implementation of a parent's method: same name and same parameters IQ
	// note: you do not inherit constructors, so cannot override them
	//@Override //@means annotations
=======

>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
	public String speak() {
		return "I am speaking";
	}

<<<<<<< HEAD
=======
	//method overriding: changing the implementation of a parent's method: same name and same parameters IQ
	// note you d not inherit constructors so you cannot override them
	@Override // @ means annotation 
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", isAlive=" + isAlive + ", gender="
				+ gender + "]";
	}
	
	

>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
}