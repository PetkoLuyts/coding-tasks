package leetcode.hashtable.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class SortThePeople {
    public static String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        String[] result = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        int i = 0;
        for (int key : map.keySet()) {
            result[i++] = map.get(key);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] names = new String[]{"Mary", "John", "Emma"};
        int[] heights = new int[]{180, 165, 170};

        String[] sorted = sortPeople(names, heights);

        System.out.println(Arrays.toString(sorted));
    }
}