package leetcode.arrays.easy;

import java.util.Arrays;

public class RunningSumOf1dArray {
    public static int[] runningSum(int[] nums) {
        int currentSum = 0;
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            result[i] = currentSum;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 10, 1};

        int[] result = runningSum(nums);

        System.out.println(Arrays.toString(result));
    }
}
