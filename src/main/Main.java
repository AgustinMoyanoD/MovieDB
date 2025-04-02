package main;

import dbConnectionSQL.MoviesDAO;
import movieModelation.Movie;

public class Main {

	public static void main(String[] args) {
		MoviesDAO moviesdb = new MoviesDAO();
		Movie movie = new Movie("Test", "TestEsp",99,2002,true,false,50,50,50,50,50);
		moviesdb.guardar(movie);
	}
}
