package leetcode.blankfactor;

import java.util.HashMap;
import java.util.Map;

public class PairsOfNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int target = 7;

        HashMap<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (!numsMap.containsKey(nums[i])) {
                    numsMap.put(nums[i], nums[i]);
                }

                if (target - numsMap.get(nums[i]) == nums[j]) {
                    numsMap.put(nums[i], nums[j]);
                }
            }
        }

        for (Map.Entry<Integer, Integer> set : numsMap.entrySet()) {
            if (set.getKey() != set.getValue()) {
                System.out.print("(" + set.getKey() + ", "
                        + set.getValue() + ")");
            }
        }
    }
}