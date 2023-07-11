package leetcode.strings.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CheckCharsHaveEqualNumberOfOccurrences {
    public static boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        int count = map.get(s.charAt(0));
        for (Map.Entry<Character, Integer> entrySet : map.entrySet()) {
            if (count != entrySet.getValue()) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(areOccurrencesEqual("abacbc"));
    }
}
