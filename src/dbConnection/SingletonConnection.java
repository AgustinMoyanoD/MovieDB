package dbConnection;
import java.sql.*;
public class SingletonConnection {
	private static Connection conn = null;
	static {
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:Movies.db"); //Get Connection
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		return conn; //return one connection.
	}
	
	private SingletonConnection() {
		
	}
	
	public void close() { 	//Close the connection
		if (conn == null) {
			System.out.printf("Ya está cerrado!.\n"); //Already closed.
		} else {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public Connection getConnection() {
		return this.conn;
	}
}
