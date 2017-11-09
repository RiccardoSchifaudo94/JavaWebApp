package com.webapp.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonParser;
import com.mysql.jdbc.Connection;
import com.webapp.DAO.*;
import com.webapp.model.User;

/**
 * Servlet implementation class ListaUserServlet
 */
@WebServlet("/ListaUserServlet")
public class ListaUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		ArrayList<User> read = null;
		
		switch(action){
			case "stampaUtenti":
				read = this.stampaUtenti();
			break;
			case "modificaUtente":
				User user = new User();
				
				user.setId(request.getParameter("id"));
				user.setNome(request.getParameter("nome"));
				user.setCognome(request.getParameter("cognome"));
				user.setEmail(request.getParameter("email"));
				this.modificaUtente(user);
				read = this.stampaUtenti();
				break;
			default:
				read = this.stampaUtenti();
			break;
		}
		
		//response.setContentType("json");
		
		Gson gson = new Gson();
		String data = gson.toJson(read);
		
	    //JsonArray jsonArray = new JsonParser().parse(data).getAsJsonArray();
	    response.setContentType("application/json");
	    response.getWriter().write(data.toString());
	 
		
	}
	
	public ArrayList<User> stampaUtenti(){
		UserDAO userDao = new UserDAO();
		ArrayList<User> read=null;
		try {
			Connection conn = (Connection)userDao.getConnection();
			read=userDao.readUsers(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return read;
	}
	
	public void modificaUtente(User user){
		UserDAO userDao = new UserDAO();
		try{
			Connection conn = (Connection) userDao.getConnection();
			userDao.udpateUser(user,conn);
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
