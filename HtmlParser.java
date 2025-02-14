import java.util.*;

public class HtmlParser {
    private static final String OPENING_TAG_REGEX = "^<[^/!][^>]*>$";
    private static final String CLOSING_TAG_REGEX = "^</[^>]*>$";
    private static final String INVALID_TEXT_REGEX = "^<[!].*>$|^<.*>$";

    /**
     * Parses the HTML and returns the deepest text found.
     * @param htmlLines List of HTML lines.
     * @return Deeper text of "malformed HTML" if not found.
     */

    public String findDeepestText(List<String> htmlLines) {
        Deque<String> tagStack = new ArrayDeque<>();
        Map<Integer, String> deepestTexts = new HashMap<>();
        int maxDepth = 0, currentDepth = 0;
        boolean insideScriptOrStyle = false;

        for (String line : htmlLines) {
            if (isOpeningTag(line)) {
                String tagName = extractTagName(line);
                if (isScriptOrStyle(tagName)) {
                    insideScriptOrStyle = true;
                }
                tagStack.push(tagName);
                currentDepth++;
            } else if (isClosingTag(line)) {
                String tagName = extractTagName(line);
                if (isScriptOrStyle(tagName)) {
                    insideScriptOrStyle = false;
                }
                if (!tagStack.isEmpty()) {
                    tagStack.pop();
                    currentDepth--;
                }
            } else if (!insideScriptOrStyle && isValidText(line)) {
                // Removes HTML tags and keeps only the textual content
                String cleanedLine = HtmlCleaner.stripHtmlTags(line);
                if (currentDepth >= maxDepth) {
                    maxDepth = currentDepth;
                    deepestTexts.putIfAbsent(currentDepth, cleanedLine);
                }
            }
        }
        return deepestTexts.getOrDefault(maxDepth, "malformed HTML");
    }

    private boolean isOpeningTag(String line) {
        return line.matches(OPENING_TAG_REGEX);
    }

    private boolean isClosingTag(String line) {
        return line.matches(CLOSING_TAG_REGEX);
    }

    private boolean isValidText(String line) {
        return !line.matches(INVALID_TEXT_REGEX);
    }

    private boolean isScriptOrStyle(String tagName) {
        return "script".equalsIgnoreCase(tagName) || "style".equalsIgnoreCase(tagName);
    }

    private String extractTagName(String tag) {
        // Remove '<', '>' and '/' characters to get the tag name
        return tag.replaceAll("[<>/]", "").split("\\s+")[0];
    }
}
