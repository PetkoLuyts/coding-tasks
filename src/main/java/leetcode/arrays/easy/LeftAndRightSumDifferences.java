package leetcode.arrays.easy;

import java.util.Arrays;

public class LeftAndRightSumDifferences {
    public static int[] leftRightDifference(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < nums.length; i++) {
            left[i] = leftSum;
            leftSum += nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = rightSum;
            rightSum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            left[i] = Math.abs(left[i] - right[i]);
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 4, 8, 3};

        int[] result = leftRightDifference(nums);

        System.out.println(Arrays.toString(result));
    }
}
