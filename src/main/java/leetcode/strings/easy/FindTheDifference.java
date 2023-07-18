package leetcode.strings.easy;

public class FindTheDifference {
    public static char findTheDifference(String s, String t) {
        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] % 2 == 1) return (char) (i + 'a');
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("", "y"));
    }
}
