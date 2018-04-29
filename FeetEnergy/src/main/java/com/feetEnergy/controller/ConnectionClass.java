package com.feetEnergy.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionClass {
	private static String connectionDriverClass="org.mariadb.jdbc.Driver";
	private static String  connectionUrl = "jdbc:mariadb://localhost:3306/feetenergy";
	private static String connectionUsername="root";
	private static String connectionPassword="";
	private static Connection conn;

	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		if(ConnectionClass.conn != null) {
			return ConnectionClass.conn;
		}else {
			Class.forName(connectionDriverClass);
			return DriverManager.getConnection(
					ConnectionClass.connectionUrl,
					ConnectionClass.connectionUsername,
					ConnectionClass.connectionPassword);
		}
		
	}
}
//jdbc:mariadb://localhost:3306/?user=root