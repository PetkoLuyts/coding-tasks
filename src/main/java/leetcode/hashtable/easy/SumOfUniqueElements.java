package leetcode.hashtable.easy;

import java.util.HashMap;

public class SumOfUniqueElements {
    public static int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            occurrences.merge(nums[i], 1, Integer::sum);
            if (occurrences.get(nums[i]) == 1) sum += nums[i];
            else if (occurrences.get(nums[i]) == 2) sum -= nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2};

        System.out.println(sumOfUnique(nums));
    }
}
