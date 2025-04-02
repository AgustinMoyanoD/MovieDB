package src.googleAPIS;

import com.google.*;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class GoogleSheetsService {
    private static final String APPLICATION_NAME = "SQLiteToSheets";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String SPREADSHEET_ID = "1tEHSonky7Su-qUmHhK-G6_3AbYQ1Lml1mjmblAyPI3Y";

    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
    	 FileInputStream serviceAccountStream = new FileInputStream("C:\\Users\\exaul\\OneDrive\\Escritorio\\API-keys\\movies-455602-228f134216cc.json");

        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccountStream)
                .createScoped(List.of("https://www.googleapis.com/auth/spreadsheets"));
        return new Sheets.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                new HttpCredentialsAdapter(credentials))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static void insertDataToSheet(List<List<Object>> data) throws IOException, GeneralSecurityException {
        Sheets service = getSheetsService();
        String range = "Hoja 1";  // Asegúrate de que "Hoja1" sea el nombre exacto de la pestaña
        ValueRange body = new ValueRange().setValues(data);
        service.spreadsheets().values()
                .update(SPREADSHEET_ID, range, body)
                .setValueInputOption("RAW")
                .execute();
    }

    
    public static String getSpreadsheetTitle(String spreadsheetId) {
        try {
            Sheets sheetsService = getSheetsService();
            Sheets.Spreadsheets.Get request = sheetsService.spreadsheets().get(spreadsheetId);
            return request.execute().getProperties().getTitle();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al obtener el título";
        }
    }

}
