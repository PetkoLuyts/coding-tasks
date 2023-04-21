package leetcode.arrays;

import java.util.Arrays;

public class BuildArrayFromPermutation {
    public static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 0, 1, 2, 3, 4};

        int[] ans = buildArray(nums);

        System.out.println(Arrays.toString(ans));
    }
}
