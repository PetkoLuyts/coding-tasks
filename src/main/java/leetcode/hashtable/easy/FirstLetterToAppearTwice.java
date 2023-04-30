package leetcode.hashtable.easy;

import java.util.HashMap;

public class FirstLetterToAppearTwice {
    public static char repeatedCharacter(String s) {
        HashMap<Character, Integer> occurrences = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            occurrences.put(s.charAt(i), occurrences.getOrDefault(s.charAt(i), 0) + 1);
            if (occurrences.get(s.charAt(i)) == 2) return s.charAt(i);
        }

        return ' ';
    }

    public static void main(String[] args) {
        String str = "abcdd";

        System.out.println(repeatedCharacter(str));
    }
}
