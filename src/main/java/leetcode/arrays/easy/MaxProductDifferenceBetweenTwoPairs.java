package leetcode.arrays.easy;

public class MaxProductDifferenceBetweenTwoPairs {
    public static int maxProductDifference(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] * nums[j] > max) max = nums[i] * nums[j];
                if (nums[i] * nums[j] < min) min = nums[i] * nums[j];
            }
        }

        return max - min;
    }

    public static void main(String[] args) {
        System.out.println(maxProductDifference(new int[]{4, 2, 5, 9, 7, 4, 8}));
    }
}
