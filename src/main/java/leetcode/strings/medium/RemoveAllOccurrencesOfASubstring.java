package leetcode.strings.medium;

public class RemoveAllOccurrencesOfASubstring {
    public static String removeOccurrences(String s, String part) {
        for (int i = 0; i < s.length(); i++) {
            if (s.startsWith(part, i)) {
                s = s.replaceFirst(part, "");
                i -= part.length();
            }
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println(removeOccurrences("aabababa", "aba"));
    }
}
