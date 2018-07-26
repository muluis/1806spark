package com.revature.abstracts;

<<<<<<< HEAD
=======
import com.revature.exceptions.NoNegativeArgumentException;

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
/*
 * 	abstract keyword can be used in 2 locations:
 * 			-classes
 * 			-methods
 * 	no such thing as an abstract variable
 */
/**
<<<<<<< HEAD
 * Sandwich class is going to be a template for creating
 * 		subclasses for specific sandwiches
 * We are going to make this class abstract
 * 
 * 		subclass examples:
 * 			-club
 * 			-dagwood
 * 			-cuban
 *
 */
public abstract class Sandwich {
	
	private int slicesOfBread;
	private String[] meats;
	private String[] toppings;
	private String name;
	protected int size; //protected variable available to: the class, the package, subclasses
//	private boolean isToasted;
	
//	no-args constructor by convention: future frameworks will require
	
	// for this class, need subclasses to instantiate it as opposed to System class
	// so can't be a private constructor
	// look into what using super() means
	// cf. making a Pet array, abstract Pet class but making room for Pet datatype placeholders
	// also, I thought that subclasses don't inherit their parent's contructors
	public Sandwich() {}
	
=======
 * Sandwich class is going to be a template for creating subclasses for specific
 * sandwiches We are going to make this class abstract
 * 
 * subclass examples: -club -dagwood -cuban
 */
public abstract class Sandwich {

	// State aka variables
	private int slicesOfBread; // not going to make protected because I handle the validation here for all of them
	private String[] meats;
	private String[] toppings;
	private String name;
	protected int size; // protected variable available to: the class, the package, the subclass

//		private boolean isToasted;

	// NO-ARGS Constructor by convention: future frameworks will require
	public Sandwich() {
	}
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	public Sandwich(int slicesOfBread, String[] meats, String[] toppings, String name, int size) {
		super();
		this.slicesOfBread = slicesOfBread;
		this.meats = meats;
		this.toppings = toppings;
		this.name = name;
		this.size = size;
	}
<<<<<<< HEAD
	
	public abstract void prepping();

	/**
	 * takeBite() decrements the sandwich by 1
	 * @return remaining size of sandwich
	 */
	public int takeBite() {
		size--;
		return size;
	}
	
	public int takeBite(int biteSize) {
		size -= biteSize;
		return size;
	}

	public int getSlicesOfBread() {
		return slicesOfBread;
	}

	/**
	 * 	Setting the property of slicesOfBread
	 * 		do not pass a negative number as an argument if you do I will set it to 0
	 * @param slicesOfBread
	 */
	public void setSlicesOfBread(int slicesOfBread) {
		if (slicesOfBread < 0) {
			System.out.println("cannot have a negative value for sliceOfBread, setting it to 0");
			this.slicesOfBread = 0;
		} else this.slicesOfBread = slicesOfBread;
	}
	
}
=======

	// Behavior
	
	public abstract void prepping();
	

	/**
	 * takeBite() decrements the sandwich by 1
	 * 
	 * @return remaining size of sandwich
	 */
	public int takeBite() {
		// this. is not required because there is no other size variable in the
		// parameter or in the method
		this.size--;
		return this.size;
	}

	public int takeBite(int biteSize) {
		this.size -= biteSize; // same as: this.size = this.size - biteSize;
		return this.size;
	}

	
	/*
	 * 	creating a getter and setter for the private variable slicesOfBread
	 */
	public int getSlicesOfBread() {
		return slicesOfBread;
	}
	
	/**
	 *  Setting the property int slicesOfBread
	 *  	do not pass a negative number as an agrument if you do I will set it to 0
	 * @param slicesOfBread
	 * @throws NoNegativeArgumentException 
	 */
	public void setSlicesOfBread(int slicesOfBread) throws NoNegativeArgumentException {
		if(slicesOfBread < 0) {
			this.slicesOfBread = 0;
			throw new NoNegativeArgumentException();
			
		}else {
			this.slicesOfBread = slicesOfBread;
		}
	}
	
	
	

}
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
