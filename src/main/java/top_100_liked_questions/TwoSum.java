package top_100_liked_questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                return new int[] {numMap.get(complement), i};
            }

            numMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No match found!");
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 5, 5, 11};

        System.out.println(Arrays.toString(twoSum(nums, 10)));
    }
}
