package com.revature.presentation;

import java.util.Scanner;

import com.revature.beans.Student;



public class PresentationUtil {
	
	/*useful class that will hold views or presentation logic.
	*/
	
	/*
	 * welcomeMenu is static, which means we will access it in another class
	 * by ClassName.methodName() OR ClassName.variableName
	 * 	PresentationUtil.welcomeMenu()
	 * 
	 * NEVER MANIPULATE THE INPUT IN PRESENTATION LOGIC.
	 */
	//as a static, it is viewable for the class itself.
	public static void welcomeMenu() {
	System.out.println("Welcome, please select from the list below:");
	System.out.println("1 Create new student");
	System.out.println("2 Read current student");
	System.out.println("3 Exit");
	}
	
	public static Student creatingNewStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("---NEW STUDENT---");
		System.out.println("Enter Student Name:");
		String studName = scan.nextLine();
		System.out.println("Enter Student GPA:");
		double studGpa = scan.nextDouble();
		System.out.println("Enter Student SSN");
		int studSsn = scan.nextInt();
		
		Student stud = new Student(55, studName,studGpa,studSsn);
		scan.close();
		System.out.println(stud);
		return stud;
		
		}
	public static void presentStudent(Student stud) {
		System.out.println("---CURRENT STUDENT----");
		System.out.println(stud);
	}
	
	public static void errorView(String message) {
		System.out.println("Sorry! Something went wrong.");
	}
}
