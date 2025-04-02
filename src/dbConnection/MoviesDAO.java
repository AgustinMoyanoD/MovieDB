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
			
			String query = "CREATE TABLE IF NOT EXISTS MOVIES ("
					+ "ID INTEGER NOT NULL,"
					+ "NAME TEXT,"
					+ "NAME_ESP TEXT,"
					+ "YEAR INTEGER,"
					+ "DURATION INTEGER,"
					+ "RATING REAL,"
					+ "WATCH_P	BLOB,"
					+ "WATCH_A	BLOB,"
					+ "DIRECTION	REAL,"
					+ "SCRIPT	REAL,"
					+ "PERFORMANCE	REAL,"
					+ "SFX REAL,"
					+ "SOUND	REAL,"
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
		    String query = "INSERT OR IGNORE INTO MOVIES (NAME,NAME_ESP, YEAR, DURATION,WATCH_P,WATCH_A,DIRECTION,SCRIPT,PERFORMANCE,SFX,SOUND, RATING) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    PreparedStatement pstmt = con.prepareStatement(query);
		    
		    pstmt.setString(1,movie.getName());
		    pstmt.setString(2,movie.getNameESP());
		    pstmt.setInt(3,movie.getYear());
		    pstmt.setInt(4,movie.getDuration());  
		    pstmt.setBoolean(5,movie.getRating().isWatchP());  
		    pstmt.setBoolean(6,movie.getRating().isWatchA());  
		    pstmt.setDouble(7,movie.getRating().getDirection());  
		    pstmt.setDouble(8,movie.getRating().getScript());  
		    pstmt.setDouble(9,movie.getRating().getPerformance());  
		    pstmt.setDouble(10,movie.getRating().getSfx());  
		    pstmt.setDouble(11,movie.getRating().getSound());
		    pstmt.setDouble(12,movie.getRating().getFinalRating());
		    
		    
		    
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
		return false;
	
	}

}
