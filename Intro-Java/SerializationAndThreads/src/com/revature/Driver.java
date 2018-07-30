package com.revature;
import java.util.Scanner;

import java.io.IOException;

import com.revature.beans.Student;
import com.revature.dao.StudentDao;
import com.revature.presentation.PresentationUtil;

public class Driver {
	
	
	/*
	 * Serialization: Java Obj to Byte Code
	 * DeSerialization: Byte Code to Java Objs
	 * 
	 * First Note: All Java Objs are blacklisted,
	 * meaining you cannot do serialization.
	 * You must whitelist each individual class so
	 * that the object created from them are allowed
	 * to be serialized.
	 * 
	 * Serializable is a "Marker Interface"
	 * 		Marker Interfaces tells the JVM something special
	 * 		- different per-case.
	 * 		Marker Interfaces have no methods.
	 * 		The something special about Serializable is the whitelisting.
	 * 1. Class must implement Serializable (whitelist)
	 * 		2. Add a serialVersionUID to the class
	 * 3. Use the ObjectOutputStream or Object Inputstream
	 * 
	 * IQ!!!!!!
	 * What is the point of the serialVersionUID?
	 * to match the version when deserializing.
	 * IFthe serialVersionUID doesnt match when deserializing?
	 * THROWS AN EXCEPTION, InvalidClassException.
	 */
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		
		
		while(true) {
		
			PresentationUtil.welcomeMenu();
			int userInput = scan.nextInt();
		
		switch (userInput) {
		case 1:
			promptUserForNewStudentAndPersist();
			break;
		case 2:
			getStudentAndDisplay();
			break;
		case 3:
			System.out.println("Leaving Program.");
			System.exit(1);
		}
		
		}
	}
	public static void promptUserForNewStudentAndPersist() {
		// first prompt user and retrieve input
		Student stud = PresentationUtil.creatingNewStudent();
		
		//persist student to file
		try{
			StudentDao.serializeStudent(stud);
		}catch (IOException e) {
		PresentationUtil.errorView("File is corrupted");
	}
	}
		public static void getStudentAndDisplay() {
			Student stud = StudentDao.deserializeStudent();
			
			PresentationUtil.presentStudent(stud);
			// probably should have ducked the exceptions in the StudentDao and handled them here with try/catch.
		}
	}
	//	System.out.println("User created" + stud);
		
		
	//when you have files youre going to use, you would put these files
	// in a special package that you could easily find.
	// separating non-Java files into a "resources" folder.

	
//	 created the obj from a class marked as Serializable
//		Student john = new Student(1,"John",4.0, 555);
	
//	serializeStudent(john, filePathAndName); //the Create of Crud
//	deserializeStudent(filePathAndName); // C. Read of cRud
	
//	Student studRead = StudentDao.deserializeStudent();
	
//	System.out.println(studRead);}
	
	// service, calling a method to save the student.
	
	// to serialize a student, i will need student and filepath. THIS IS NOT SHADOWING.
	// I have two variables with same name, but, theyre not in the same scope.
	
	/*moving these CRUD methods to the package DAO.
	 * DAO is a type of design pattern 
	 * Data Access Object. (Its an object I'm going to use to access data!)
	 * serialize and deserialize are DAO.
	 * 
	 * */


