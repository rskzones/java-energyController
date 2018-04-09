package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;;

public class UserJdbcDAO {
	
	private Connection conn;
	
	public UserJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
/*	public void logar(User l) throws SQLException {
		
	//	String sql = " SELECT usuario, senha FROM usuarios  WHERE usuario = " + l.getUserName() + " and senha = " + String.valueOf(l.getPassUser());
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
			
		}
	}*/
	
}
