import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextSample {
    public static String readFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        int bufferSize = 1012000;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath), bufferSize)) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n"); // Append each line to the StringBuilder
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception as per your requirement
        }

        return stringBuilder.toString();
    }
}
