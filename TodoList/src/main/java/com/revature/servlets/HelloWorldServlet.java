package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Making a Servlet
 * 
 * Verify HttpServlet
 * 
 * -Extends HttpServlet
 *
 *HTTp servlet is a class found from the specific implementation 
 *of web container software you chose like tomcat or weblogic*
 *you need the jar to import httpservlet
 * 
 * 
 */

public class HelloWorldServlet extends HttpServlet{
	
	/*
	 * A servlet to handle requests and send back responses
	 * must specify which endpoint this servlet will handle
	 * 
	 * URL- /hello
	 */
	
	//handle a request at the endpoint /hello
	
	//KNOW servlet DO signatureVVVVVVVVVVVVVVVVVVVVVVVV!!!!!!!!!!!!! throws etc.
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException{
		System.out.println("Hello World -GET");
	}

}
