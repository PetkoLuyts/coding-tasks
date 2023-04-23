package leetcode.arrays;

import java.util.Arrays;

public class HowManyNumsAreSmallerThanCurrentNum {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] != nums[j] && nums[i] > nums[j]) {
                    result[i]++;
                }
            }
        }

        return result;

// Second solution
//        Map<Integer, Integer> map = new HashMap<>();
//        int[] copy = nums.clone();
//
//        Arrays.sort(copy);
//
//        for (int i = 0; i < nums.length; i++) {
//            map.putIfAbsent(copy[i], i);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            copy[i] = map.get(nums[i]);
//        }
//
//        return copy;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 2, 2, 3};

        int[] result = smallerNumbersThanCurrent(nums);

        System.out.println(Arrays.toString(result));
    }
}
