package com.webapp.DAO;

import java.lang.String;
import java.sql.*;
import java.util.ArrayList;

import com.webapp.model.User;


public final class UserDAO {
	
	public void createUser(String[] parameters,Connection conn) throws SQLException, Exception{
		//System.out.println("parametri di create user nome => "+parameters[0]+" cognome =>"+parameters[1]+" email=>"+parameters[2]);
		String query = "INSERT INTO user SET nome = '"+parameters[0]+"' ,cognome = '"+parameters[1]+"', email ='"+parameters[2]+"';";
		//System.out.println(query);
		PreparedStatement stmt =null;
		try{
			if(conn!=null){
				conn.setAutoCommit(true);
				stmt= conn.prepareStatement(query);
				stmt.execute(query);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null){
				conn.close();
			}
			if(stmt!=null){
				stmt.close();
			}
		}
		
				
	}
	
	public ArrayList<User> readUsers(Connection conn){
		ArrayList<User> user = new ArrayList<User>();
		String query = "SELECT * FROM user;";
		ResultSet ris;
		//System.out.println(query);
		PreparedStatement stmt = null;
		try{
			if(conn!=null){
				conn.setAutoCommit(true);
				stmt= conn.prepareStatement(query);
				ris = stmt.executeQuery(query);
				while(ris.next()){
					User userModel = new User();
					userModel.setId(ris.getString("id"));
					userModel.setNome(ris.getString("nome"));
					userModel.setCognome(ris.getString("cognome"));
					userModel.setEmail(ris.getString("email"));
					user.add(userModel);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return user;
	}
	
	public void udpateUser(User user, Connection conn) throws SQLException, Exception{
		

		String query = "UPDATE user SET nome = '"+user.getNome()+"' , cognome = '"+user.getCognome()+"' , email = '"+user.getEmail()+"' WHERE id='"+user.getId()+"';";
		PreparedStatement stmt = null;
		//System.out.println(query);
		
		if(conn!=null){
			conn.setAutoCommit(true);
			stmt = conn.prepareStatement(query);
			stmt.executeQuery(query);
		}
		

	}
	
	public Connection getConnection() throws SQLException, Exception{	
				
		String driver = "com.mysql.jdbc.Driver";
			    String connection = "jdbc:mysql://localhost:3306/db_java";
			    String user = "root";
			    String password = "";
			    Class.forName(driver);
			    Connection con = DriverManager.getConnection(connection, user, password);
			    return con;
	}
	
}
