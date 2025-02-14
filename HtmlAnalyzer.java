import java.io.IOException;
import java.util.List;

public class HtmlAnalyzer {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java HtmlAnalyzer <URL>");
            return;
        }

        String url = args[0];
        try {
            HtmlFetcher fetcher = new HtmlFetcher();
            List<String> htmlLines = fetcher.fetchHtml(url);

            HtmlParser parser = new HtmlParser();
            String deepestText = parser.findDeepestText(htmlLines);

            System.out.println(deepestText);
        } catch (IOException e) {
            System.out.println("URL connection error");
        }
    }
}