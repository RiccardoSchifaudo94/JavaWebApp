package com.webapp.controllers;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.String;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.webapp.DAO.*;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String nome = request.getParameter("nome");
	    String cognome = request.getParameter("cognome");
	    String email = request.getParameter("email");
	    
	    //System.out.println("Nome = >"+nome+" Cognome =>"+cognome+" Email =>"+email);
		
	    request.getSession().setAttribute("nome",nome);
	    request.getSession().setAttribute("cognome",cognome);
	    request.getSession().setAttribute("email",email);
	    
	    UserDAO userDAO = new UserDAO();
	    
	    String[] parameters = new String[3];
	    
	    parameters[0] = nome;
	    parameters[1] = cognome;
	    parameters[2] = email;
	    
	    try {
	    	Connection con=(Connection) userDAO.getConnection();
			userDAO.createUser(parameters, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    response.sendRedirect("VisualizzaAnagrafica.jsp");
	}

}
