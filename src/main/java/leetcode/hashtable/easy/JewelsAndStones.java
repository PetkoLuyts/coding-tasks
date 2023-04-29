package leetcode.hashtable.easy;

import java.util.HashMap;

public class JewelsAndStones {
    public static int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> elements = new HashMap<>();

        for (int i = 0; i < jewels.length(); i++) {
            elements.put(jewels.charAt(i), 0);
        }

        for (int i = 0; i < stones.length(); i++) {
            if (elements.containsKey(stones.charAt(i))) {
                elements.merge(stones.charAt(i), 1, Integer::sum);
            }
        }

        return elements.values().stream().mapToInt(e -> e).sum();
    }

    public static void main(String[] args) {
        String jewels = "z";
        String stones = "ZZ";

        System.out.println(numJewelsInStones(jewels, stones));
    }
}
