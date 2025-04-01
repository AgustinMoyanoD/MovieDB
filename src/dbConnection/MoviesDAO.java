package dbConnection;
import java.sql.*;

public class MoviesDAO{
	private Connection con;
	public MoviesDAO() {
		con = SingletonConnection.getCon(); //
		
	}

}
