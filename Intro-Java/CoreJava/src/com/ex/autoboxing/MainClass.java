package com.ex.autoboxing;

public class MainClass {
	public static void main(String[] args) {
		
		/*
		 * Every single primitive datatype has a corresponding object
		 * 
		 * 		int-> Integer
		 * 		char -> Character
		 * 		boolean -> Boolean
		 * 		etc...
		 * 
		 * 	This is to allow primitve datatypes to be used as objects
		 */
		
		/*
		 * Boxing: primitive to Object (old way)
		 */
		int 	num1 = 5;
		Integer num2 = new Integer(num1);
		
		/*
		 * Unboxing: Object to primitive
		 * 	automatically converts primitive to objects without the new keyword
		 */
		Integer num3 = new Integer(5);
		int 	num4 = num3.intValue();
		
		
		/*
		 * Autoboxing - Since Java 1.5
		 */
		int 	num5 = 5;
		Integer num6 = num5;
		
		
		
		/*
		 * Auto Unboxing - Since Java 1.5
		 */
		Integer num7 = 5;
		int num8 = num7;
		
		
		
	}
}
