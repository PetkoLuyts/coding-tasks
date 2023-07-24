package leetcode.strings.medium;

public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] splitted = s.trim().split("\\s+");

        for (int i = splitted.length - 1; i >= 0; i--) {
            sb.append(splitted[i]).append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
}
