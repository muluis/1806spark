//LABEL A
package com.project.objs;

public abstract class Cutter  {

	protected String name;
	protected int degreeSharpness;
	
	public Cutter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cutter(String name, int degreeSharpness) {
		super();
		this.getName();
		this.getDegreeSharpness();
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDegreeSharpness() {
		return degreeSharpness;
	}
	public void setDegreeSharpness(int degreeSharpness) {
		this.degreeSharpness = degreeSharpness;
	}
	
	abstract void Slice();
	
	
	
	
}