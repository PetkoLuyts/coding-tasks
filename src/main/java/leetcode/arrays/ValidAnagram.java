package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.equals(t)) return true;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            sMap.merge(s.charAt(i), 1, Integer::sum);
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }

        for(Character c : sMap.keySet()) {
            if(!sMap.get(c).equals(tMap.get(c))) return false;
        }

        return true;

//        Second solution
//        int[] alphabet = new int[26];
//        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
//        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
//        for (int i : alphabet) if (i != 0) return false;
//        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}
