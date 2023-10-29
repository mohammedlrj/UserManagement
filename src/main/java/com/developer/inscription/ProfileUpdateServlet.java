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
import java.sql.SQLException;

@WebServlet("/update")
public class ProfileUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final static String UPDATE_QUERY = "UPDATE utilisateurs SET nom = ?, prenom = ?, email = ?, mdp = ? WHERE id = ?";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_utilisateurs_db", "root", "simo135");

            PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, email);
            ps.setString(4, mdp);
            ps.setInt(5, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                session.setAttribute("nom", nom);
                session.setAttribute("prenom", prenom);
                session.setAttribute("email", email);
                session.setAttribute("mdp", mdp);
                response.sendRedirect("profil.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}