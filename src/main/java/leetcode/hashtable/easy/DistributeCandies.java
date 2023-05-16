package leetcode.hashtable.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public static int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();

        for(int candy: candyType) {
            set.add(candy);
        }

        return Math.min(candyType.length / 2, set.size());

//        2nd solution
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int num : candyType) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        if (map.size() >= candyType.length / 2) {
//            return candyType.length / 2;
//        } else {
//            return map.size();
//        }
    }

    public static void main(String[] args) {
        int[] candyType = new int[]{1, 1, 2, 2, 3, 3};
        System.out.println(distributeCandies(candyType));
    }
}
