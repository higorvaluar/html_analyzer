import java.io.*;
import java.net.*;
import java.util.*;

public class HtmlFetcher {
    /**
     * Performs an HTTP GET request and returns the HTML as a list of lines.
     * @param urlString URL of the website to be analyzed.
     * @return List of HTML lines.
     * @throws IOException If there is an error connecting to the URL.
     */
    public List<String> fetchHtml(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        List<String> htmlLines = new ArrayList<>();

        // Correct declaration of BufferedReader inside try-with-resources
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    htmlLines.add(line);
                }
            }
        } finally {
            connection.disconnect(); // Closes the connection when finished
        }
        return htmlLines;
    }
}
