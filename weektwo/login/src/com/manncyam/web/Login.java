/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 2: Implement doPost()
 *  Date: 3/3/21
 *  
 */
package com.manncyam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Mannchuoy Yam
 *
 */
@WebServlet("/")
public class Login extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3815782959266028156L;
	private Hashtable<String, String> users = new Hashtable<String, String>();
	
	private final String loginForm = "<form action=\"\" method=\"POST\">"
			+ "Username: <input type = \"text\" name = \"user_name\"/><br>"
			+ "Password: <input type = \"password\" name = \"password\"/><br>"
			+ "<input type=\"submit\" value=\"Login\" /></form>";
	
	public Login() {
		// Hard coded username and password for this project
		users.put("mann", "12345");
		users.put("jerry", "12345");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String htmlResponse = "<html><body>"
				+ loginForm
				+ "</body></<html>";

		PrintWriter writer = resp.getWriter();
		writer.write(htmlResponse);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("user_name");
		String password = req.getParameter("password");
		
		String userPassword = users.get(username.toLowerCase());  
		
		// very usrename and password
		if(userPassword != null && userPassword.equals(password) ) {
			String htmlResponse = "<html><body>"
					+ "<h2><small>Welcome</small> <span style=\"color:blue;\">" + username.toUpperCase() + "</span></h2>"
					+ "</body></<html>";
			
			PrintWriter writer = resp.getWriter();
			writer.write(htmlResponse);
		}else {
			String htmlResponse = "<html><body>"
					+ "<p style=\"color:red;\">Either username or password is incorrect.<br>Please try again.</p>"
					+ loginForm
					+ "</body></<html>";

			PrintWriter writer = resp.getWriter();
			writer.write(htmlResponse);				
		}
	}
}
