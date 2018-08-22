package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.domain.Reimbursement;
import com.revature.service.ReimbursementBuisnessLogic;

/**
 * Servlet implementation class ReimbursementServlet
 */
public class ReimbursementServlet extends HttpServlet {
	
	/*
	 * url - /reimbursement
	 */
	
	private ReimbursementBuisnessLogic reimBL = new ReimbursementBuisnessLogic();
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Reimbursement> reimbursements = reimBL.getAllReimbursemets();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbursements);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(json);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Hit post method");
		
		Reimbursement reimb = new Reimbursement();
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = req.getInputStream();
		ObjectNode node = mapper.readValue(data, ObjectNode.class);
		
		reimb = new Reimbursement(node.get("u_id").intValue(), node.get("amt").doubleValue(), node.get("desc").textValue(), null, node.get("type").intValue());
		
		System.out.println(reimb);
		
		reimBL.createReimbursement(reimb);
		
		
		
	}

	
}
