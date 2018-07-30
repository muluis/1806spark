package com.revature.beans;

import java.io.Serializable;

import com.revature.abstracts.Teachables;

/*
 * Student class is not just a POJO
 * It is a JavaBean, stricter version of POJO.
 * 
 * 1. State must be fully encapsulated, not random access.
 * 2. Provide getters and setters where needed.
 * - i may want it to be read only.
 * 3. must have a no-args constructor.
 * 4. class must implement Serializable.
 * 5. Override toString() method.
 * 
 * 
 * JavaBeans follow a strict methodology, cannot be one without these 5 steps.
 * */

	
public class Student implements Serializable, Teachables {

	/**
	 * Used to deserialize and match the correct version that was used when serializing.
	 * OPTIONAL, NOT REQUIRED TO PROVIDE IT. BUT IS BEST PRACTICE.
	 */
	
	private static final long serialVersionUID = 101;
	private int id;
	private String name;
	private double gpa;
	private transient int ssn;
	/*
	 * transient keyword is ONLY used in serialization
	 * 		Ignore any state that is marked transient
	 * 		during serialization.
	 * 
	 * it will become the datatype default(0, null)
	 * */
	
	
	
	public Student() {}; //no args
	
	
	public Student(int id, String name, double gpa, int ssn) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
		this.ssn = ssn;
	}
	
	@Override
	public void learn() {
		System.out.println("Student learns.");
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	


	public int getSsn() {
		return ssn;
	}


	public void setSsn(int ssn) {
		this.ssn = ssn;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + "ssn="+ssn+ "]";
	}
	
	
};
