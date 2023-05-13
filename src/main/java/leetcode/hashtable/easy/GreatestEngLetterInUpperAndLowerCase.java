package leetcode.hashtable.easy;

import java.util.HashSet;
import java.util.Set;

public class GreatestEngLetterInUpperAndLowerCase {
    public static String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            set.add(ch);
        }

        for (char ch = 'Z'; ch >= 'A'; ch--) {
            if (set.contains(ch) && set.contains(Character.toLowerCase(ch))) {
                return "" + ch;
            }
        }

        return "";

        // Second solution

//        for (char c = 'Z'; c >= 'A'; c--)
//            if(s.indexOf(c) != -1 && s.indexOf(Character.toLowerCase(c)) != -1)
//            return String.valueOf(c);
//        return "";
    }

    public static void main(String[] args) {
        String s = "lEeTcOdE";

        System.out.println(greatestLetter(s));
    }
}
