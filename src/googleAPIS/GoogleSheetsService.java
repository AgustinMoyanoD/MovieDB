Package googleAPIS;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.http.HttpCredentialsAdapter;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class GoogleSheetsService {
    private static final String APPLICATION_NAME = "SQLiteToSheets";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String SPREADSHEET_ID = "MOVIES_REPO";

    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        FileInputStream serviceAccountStream = new FileInputStream("C:\\Users\\exaul\\OneDrive\\Escritorio\\API-keys\\52dkgb4qj9i9d0t6ev8s33fp0hf6cubl.apps.googleusercontent.com.json");
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
        String range = "Hoja1!A1";  // Cambia "Hoja1" según la pestaña de la hoja
        ValueRange body = new ValueRange().setValues(data);
        service.spreadsheets().values()
                .update(SPREADSHEET_ID, range, body)
                .setValueInputOption("RAW")
                .execute();
    }
}
