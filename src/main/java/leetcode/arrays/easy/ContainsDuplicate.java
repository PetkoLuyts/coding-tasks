package leetcode.arrays.easy;

import java.util.HashMap;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};

        System.out.println(containsDuplicate(nums));
    }
}
