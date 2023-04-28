package leetcode.arrays.easy;

import java.util.HashSet;
import java.util.Set;

public class NumberOfArithmeticTriplets {
    public static int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num - diff) && seen.contains(num - diff * 2)) {
                ++count;
            }
            seen.add(num);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 4, 6, 7, 10};
        int diff = 3;

        int numberOfTriplets = arithmeticTriplets(nums, diff);

        System.out.println(numberOfTriplets);
    }
}
