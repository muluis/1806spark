package com.revature.threads;
								//is a concrete class. not an abstract w/ concrete methods.
public class ChildThread extends Thread {
	
	@Override
public void run() {
	// this code will execute when creating a new thread.
		
		for(int j = 0; j < 10; j++) {
	System.out.println("\t\t " + "Child" + " j:"+ j);
//	System.out.println("\t\t " + Thread.currentThread() + " j:"+ j);
	
		}
	}
}
