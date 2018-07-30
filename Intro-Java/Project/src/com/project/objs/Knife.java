// label B
package com.project.objs;

import java.io.Serializable;

import com.project.Interface;

public class Knife extends Cutter implements Interface, Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 101L;




	public Knife() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Knife(String name, int degreeSharpness) {
		super(name, degreeSharpness);
	}
	@Override
	public void Slice(){
		if(this.getDegreeSharpness() < 1) {
			System.out.println("Too dull to cut the bread.");
		}else{
		System.out.println( "You slice the bread.");
			}
		}
	public int Sharpen(){
		this.degreeSharpness++;
		System.out.println("You sharpen your blade");
		return this.getDegreeSharpness();
			}
	
		
		

	@Override
	public String toString() {
		return "[Name " + getName() + ", Degree of Sharpness " + getDegreeSharpness()+"]";
	}


};
	


