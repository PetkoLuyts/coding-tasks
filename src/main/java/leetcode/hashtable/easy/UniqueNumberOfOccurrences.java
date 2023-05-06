package leetcode.hashtable.easy;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        HashSet<Integer> unique = new HashSet<>();
        HashMap<Integer, Integer> occurrencesMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            occurrencesMap.put(arr[i], occurrencesMap.getOrDefault(arr[i], 0) + 1);
        }

        for (Integer key : occurrencesMap.keySet()) {
            unique.add(occurrencesMap.get(key));
        }

        if (unique.size() != occurrencesMap.size()) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 1, 1, 3};

        System.out.println(uniqueOccurrences(arr));
    }
}
