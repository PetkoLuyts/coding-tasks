package leetcode.strings.easy;

public class PercentageOfLetterInString {
    public static int percentageLetter(String s, char letter) {
        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        double result = ((double)alphabet[letter - 'a'] / s.length()) * 100;

        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(percentageLetter("foobar", 'o'));
    }
}
