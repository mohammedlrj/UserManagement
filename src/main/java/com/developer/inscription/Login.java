package com.developer.inscription;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        HttpSession session = request.getSession();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_utilisateurs_db", "root", "simo135");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM utilisateurs WHERE email = ? AND mdp = ?");
            ps.setString(1, email);
            ps.setString(2, mdp);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	session.setAttribute("id", rs.getString("id"));
                session.setAttribute("nom", rs.getString("nom"));
                session.setAttribute("prenom", rs.getString("prenom"));
                session.setAttribute("email", rs.getString("email"));
                session.setAttribute("mdp", rs.getString("mdp"));
                response.sendRedirect("profil.jsp");
            } else {
                request.setAttribute("status", "failed");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Gestion de l'erreur, rediriger vers une page d'erreur ou afficher un message d'erreur approprié
            response.sendRedirect("error.html");
        }
    }
}