package neetcode.arrays_and_hashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }

        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
