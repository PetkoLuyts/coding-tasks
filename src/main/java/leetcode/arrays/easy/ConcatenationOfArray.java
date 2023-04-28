package leetcode.arrays.easy;

import java.util.Arrays;

public class ConcatenationOfArray {
    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i + n] = nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};

        int[] ans = getConcatenation(nums);

        System.out.println(Arrays.toString(ans));
    }
}
