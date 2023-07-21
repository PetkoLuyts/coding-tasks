package leetcode.strings.easy;

public class CheckIfWordOccursAsPrefixOfAnyWordInSentence {
    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] splitted = sentence.split(" ");

        for (int i = 0; i < splitted.length; i++) {
            if (splitted[i].startsWith(searchWord)) return i + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("i love eating burger", "burg"));
    }
}
