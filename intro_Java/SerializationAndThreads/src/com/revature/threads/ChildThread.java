package com.revature.threads;

public class ChildThread extends Thread {
	
	
	
	@Override
	public void run() {
		//this is the code that will execute when creating a new thread
		
		for(int j = 0; j < 10; j++) {
			System.out.println("\t\t " + "EmailHr"+ "j: " + j);
		}

	}

}
