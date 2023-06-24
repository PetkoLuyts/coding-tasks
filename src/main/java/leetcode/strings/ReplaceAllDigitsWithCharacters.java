package leetcode.strings;

import java.util.Arrays;

public class ReplaceAllDigitsWithCharacters {
    public static String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        char[] alphabet = new char[26];

        for (char ch = 'a'; ch <= 'z'; ch++) {
            alphabet[ch - 'a'] = ch;
        }

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                sb.append(s.charAt(i));
            } else {
                //int index = Arrays.indexOf();
                char charToAppend = alphabet[s.charAt(i) + i];
                sb.append(charToAppend);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "v0g6s4d";

        System.out.println(replaceDigits(s));
    }
}
