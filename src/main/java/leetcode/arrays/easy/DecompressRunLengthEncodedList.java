package leetcode.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class DecompressRunLengthEncodedList {
    public static int[] decompressRLEList(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 2) {
            int frequency = nums[i];
            int value = nums[i + 1];

            for (int j = 0; j < frequency; j++) {
                list.add(value);
            }
        }

        return list.stream().mapToInt(num -> num).toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};

        int[] result = decompressRLEList(nums);

        System.out.println(Arrays.toString(result));
    }
}
