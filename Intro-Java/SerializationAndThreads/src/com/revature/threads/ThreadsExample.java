package com.revature.threads;

public class ThreadsExample {
/*
 * What is a thread?
 * INDIVIDUAL TASK, PROCESS
 * Each thread in java gets its own Memory Stack.
 * It will have the access to the same Heap.
 * 
 * MultiThreading...
 * Multiple threads in a single application.
 * 
 * How do we create threads in Java?
 * 	Two ways:
 * Create a class that...
 * -Extends Threads class, then override the run()
 * 		+ then create an instance of the childthread and call .start()
 * -implements Runnable and overrides the run().
 * 		then create an instance of the class that implements Runnable
 * 		and create an instance of Thread with the runnable as the constructor arg.
 * 		and finally, call .start()
 *
 * 
 * 
 * two important methods of a thread
 * - run(); contains the code to execute // you NEVER CALL THE RUN METHOD.
 * - start(); creates the new thread, invoke run() on the new thread, terminates the thread.
 * 
 * Cannot control when a thread will execute over another thread in Java.
 * 
 * 	Starvation: When a Thread is waiting for processing time and not getting it.
 * 
 * Deadlock: When you have two threads 
 * 
 * eg. 2 Threads, A and B
 * 				A has resource X locked(in use)
 *				B has resource y locked (in use)
 * 
 * A also needs resource y to finish
 * B also needs resource X to finish
 * 
 * Neither finish because both are waiting for the other.
 * 
 * Resource could be a method, or something like the console.
 * 
 * Synchronized keyword: makes a method Thread safe...
 * meaning only one thread can access it at a time.
 * */
public static void main(String[] args) {
	System.out.println("Threads");
	
//	samo.
//	Thread t1 = new Thread();
	Thread t2 = new ChildThread(); //ChildThread actually had implementation for the run method.
	t2.start();
	
	Runnable ehr = new EmailHr();
	Thread t3 = new Thread(ehr);
	t3.start();
	//t2.run();//when calling the run() I will execute it on the SAME thread.
	
	//PAUSES AND CAUSES THE THREAD TO SLEEP.
//	Thread.sleep(millis);
	
	for(int i=0; i<10; i++) {
		System.out.println("Current Thread//// " + "Main" + " i:"+ i);
	}
}
}
