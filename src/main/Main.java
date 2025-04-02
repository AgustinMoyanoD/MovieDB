package src.main;


import com.google.*;

import src.dbConnectionSQL.MoviesDAO;
import src.googleAPIS.GoogleSheetsService;
public class Main {

	public static void main(String[] args) {
		MoviesDAO moviesdb = new MoviesDAO();
		String spreadsheetId = "1tEHSonky7Su-qUmHhK-G6_3AbYQ1Lml1mjmblAyPI3Y";
		String title = GoogleSheetsService.getSpreadsheetTitle(spreadsheetId);
		moviesdb.exportGoogleSheet();
	}
}
