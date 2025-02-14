public class HtmlCleaner {
    /**
     * Removes all HTML tags and returns only the clean text.
     * @param text String containing HTML.
     * @return Clean text without tags.
     */
    public static String stripHtmlTags(String text) {
        return text.replaceAll("<[^>]+>", "").trim();
    }
}
