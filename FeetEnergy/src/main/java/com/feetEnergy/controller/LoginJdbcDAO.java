package com.feetEnergy.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginJdbcDAO {
	
	private Connection conn;
	
	public LoginJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	 public boolean checkLogin(String user, String pass) {

	        ResultSet rs = null;
	        String sql = "SELECT * FROM user WHERE username = ? and password = ?" ;
	        boolean check = false;

	        try {
	        	
	        	PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
	            preparedStatement.setString(1, user);
	            preparedStatement.setString(2, pass);

	            rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	                
	                check = true;
	            }
	            preparedStatement.close();
	            
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        } 

	        return check;

	    }
	
}
