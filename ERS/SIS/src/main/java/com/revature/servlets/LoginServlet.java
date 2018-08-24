package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Users;
import com.revature.service.Service;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Service ss = new Service();
 
    public LoginServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Users test = ss.login(email, password);
		
		System.out.println("Success!");
		System.out.println(test);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Login ---Post");
	
	
//		BufferedReader br = request.getReader();
//		ObjectMapper map = new ObjectMapper();
//		Users usr = map.readValue(br, Users.class);
//		System.out.println("Users: " + usr);
//		System.out.println(br);
//		
	}

}
