package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
		
	private static String connectionDriverClass="com.mysql.jdbc.Driver";
	private static String  connectionUrl = "jdbc:mysql://localhost/energyController";
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
