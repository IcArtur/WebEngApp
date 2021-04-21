package com.guida;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/RegistrationServlet")

public class RegistrationServlet extends HttpServlet 
{

	public RegistrationServlet() {
		
		super();
		
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		
			
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		try {
			String name = request.getParameter("user");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String sql = "insert into registrazione(name,password,email) Values(?,?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/guidatv","root","");
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, password);
			pst.setString(3, email);
			pst.executeUpdate();
			PrintWriter out = response.getWriter();
			
			if(name != null) {
			
			out.println("ti sei registrato");
			
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
