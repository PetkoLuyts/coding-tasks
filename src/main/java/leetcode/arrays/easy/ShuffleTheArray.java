package leetcode.arrays.easy;

import java.util.Arrays;

public class ShuffleTheArray {
    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[n * 2];

        for (int i = 0, j = n, idx = 0; idx < res.length; i++, j++) {
            res[idx++] = nums[i];
            res[idx++] = nums[j];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 1, 3, 4, 7};

        int[] res = shuffle(nums, nums.length / 2);

        System.out.println(Arrays.toString(res));
    }
}
