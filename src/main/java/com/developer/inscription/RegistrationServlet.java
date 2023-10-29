package com.developer.inscription;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String query = "insert into utilisateurs(nom,prenom,email,mdp) values(?,?,?,?)";
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
    	// Retrieve form data
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        // Validate the data (you can add additional validations as needed)
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e) {
        	e.printStackTrace();
        }
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_utilisateurs_db","root","simo135");
        		PreparedStatement ps = con.prepareStatement(query)){
        	ps.setString(1, nom);
        	ps.setString(2, prenom);
        	ps.setString(3, email);
        	ps.setString(4, mdp);
        	int count = ps.executeUpdate();
        	if(count==1) {
        		pw.println("<h2>User Registered Successfully</h2>");
        	}else {
        		pw.println("<h2>User Not Registered</h2>");
        	}
        	
        }catch(SQLException se) {
        	pw.println("<h2>"+se.getMessage()+"</h2>");
        	se.printStackTrace();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}

}
