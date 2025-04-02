package dbConnection;
import java.sql.*;

import movieModelation.Movie;

public class MoviesDAO{
	private Connection con;
	public MoviesDAO() {
		con = SingletonConnection.getCon(); //Get connection to SQLite.
		this.createTable(); //Create movies table.
	}
	
	private boolean createTable(){
		try {
			
			String query = "CREATE TABLE IF NOT EXIST MOVIES ("
					+ "ID INTEGER NOT NULL,"
					+ "NAME TEXT,"
					+ "YEAR INTEGER,"
					+ "DURATION INTEGER,"
					+ "RATING REAL,"
					+ "PRIMARY KEY(ID AUTOINCREMENT)"
					+ ");";
			Statement pstmt = con.createStatement();
			pstmt.execute(query);
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		} 

		return true;

	}
	public boolean guardar(Movie movie) //Stores a film in the db.
	{
		try {
		    String query = "INSERT OR IGNORE INTO COIN (NAME, YEAR, DURATION, RATING) VALUES (?, ?, ?, ?)";
		    PreparedStatement pstmt = con.prepareStatement(query);
		    
		    pstmt.setString(1,movie.getName());
		    pstmt.setInt(2,movie.getYear());
		    pstmt.setInt(3,movie.getDuration());  
		    pstmt.setDouble(4,movie.getRating());
		    pstmt.executeUpdate();
		    pstmt.close();
		  return true;
		} catch (SQLException e) {
			switch (e.getErrorCode()) {
			case 19:
			    	System.out.println("La sigla de criptomoneda ya existe (debe ser única)");
			    	break;
			default:
			    System.out.println(e.getMessage());
			    break;
			}
		}		
		//System.out.println("¡Se agregó con éxito la criptomoneda a la base de datos!");
		return false;
	
	}

}
