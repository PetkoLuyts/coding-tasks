package leetcode.hashtable.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheTownJudge {
    public static int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < trust.length; i++) {
            set.add(trust[i][0]);

            int key = trust[i][1];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == n - 1 && !set.contains(key)){
                return key;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 3;

        int[][] trust = new int[][]{
//                {1, 3}, {2, 3}, {3, 1}
                {1, 3}, {2, 3}
//                {1, 2}
        };

        System.out.println(findJudge(3, trust));
    }
}
