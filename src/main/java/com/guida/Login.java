package com.guida;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Login")

public class Login extends HttpServlet{

	public Login() {
		
		super();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		

		try {
			String name = request.getParameter("user");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String dbName = null;
			String dbPassword = null;
			String dbEmail = null;
			String sql = "select * from registrazione where name=? and password=? ";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/guidatv","root","");
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			PrintWriter out = response.getWriter();
			
			while(rs.next()) {
				
				dbName = rs.getString(2);
				dbPassword = rs.getString(3);
				
				
				
			}
			if(name.equals(dbName)&& password.equals(dbPassword)) {
				
				
				HttpSession session = request.getSession();
				session.setAttribute("user", name);
				response.sendRedirect("welcome.jsp");
			}
			
			else {
				
				out.println("login fallito");
				
				
			}
		
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

}
