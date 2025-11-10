package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.RegisterDAO;
import com.keane.training.domain.User;

public class RegisterMaster implements HttpRequestHandler 
{

	static Logger log = Logger.getLogger(RegisterUser.class);

	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.print("calling register master ..   ");
		
		// String user = r..
		
		
		
		
		
		
		
	}
	
	
	
	

}









/*	RegisterDAO dao = new RegisterDAO();
	User user = new User();
	
	
	user.setPortalID(Integer.parseInt(request.getParameter("portal_id")));
	user.setName(request.getParameter("name"));
	user.setEmployeeId(Integer.parseInt(request.getParameter("emp_id")));
	user.setTechnology(request.getParameter("tech"));
	*/
	