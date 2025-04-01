package dbConnection;
import java.sql.*;
public class SingletonConnection {
	private static Connection conn = null;
	static {
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:myDB.db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		return conn;
	}
	
	private SingletonConnection() {
		
	}
	
	public void close() {
		if (conn == null) {
			System.out.printf("Ya está cerrado!.\n");
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
