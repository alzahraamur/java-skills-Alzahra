public class TextProcessor {
    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    // Replace specific words
    public static String replaceWord(String text, String oldWord, String newWord) {
        if (text == null || oldWord == null || newWord == null) {
            return text;
        }
        return text.replace(oldWord, newWord);
    }

    public static void main(String[] args) {
        String text = "Java is fun and Java is powerful";


        int wordCount = countWords(text);
        System.out.println("Original text: " + text);
        System.out.println("Word count: " + wordCount);


        String replacedText = replaceWord(text, "Java", "Programming");
        System.out.println("After replacement: " + replacedText);
    }
}

