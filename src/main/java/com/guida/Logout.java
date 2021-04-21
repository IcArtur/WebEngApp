package com.guida;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/Logout")

public class Logout extends HttpServlet{

	public Logout() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
				
		HttpSession session = request.getSession();
		
		
		session.removeAttribute("user");
		
		session.invalidate();
		
		PrintWriter out = response.getWriter();
		
		out.println("logout");
		
	}
}
