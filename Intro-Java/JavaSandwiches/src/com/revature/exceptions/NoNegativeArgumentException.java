package com.revature.exceptions;

/*
 * Custom exception to make sure the developer clearly knows
 * to check the userInput for negative numbers.
 * 
 * 2 choices to extend Exception or RuntimeException.
 *  Exception - checked, developer must handle with try/catch for the time code doesnt work.
 *  RunTimeException - unchecked, developer needs to code around the issue NOT use try/catch.
 * */

public class NoNegativeArgumentException extends RuntimeException {

	
	public NoNegativeArgumentException() {
	}
	public NoNegativeArgumentException(String message) {
		super(message);
		
	}
	
	
	
}
