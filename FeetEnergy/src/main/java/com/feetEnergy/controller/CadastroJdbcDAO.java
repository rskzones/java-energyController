package com.feetEnergy.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.feetEnergy.model.User;


public class CadastroJdbcDAO {
	
	private Connection conn;
	
	public CadastroJdbcDAO(Connection conn) {
		this.conn = conn;
		
		
		
	}
	public void Salvar(User u) throws SQLException {
		String sql = "insert into user (username, password) values ('"+u.getUser()+"','"+u.getPass()+"')";
	//	System.out.println(sql);
		PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
		/*
		preparedStatement.setString(0, u.getUser());
		preparedStatement.setString(1, u.getPass());*/
		

		preparedStatement.executeUpdate();
        preparedStatement.close();
	}
}


