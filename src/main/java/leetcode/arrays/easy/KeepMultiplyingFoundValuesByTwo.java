package leetcode.arrays.easy;

public class KeepMultiplyingFoundValuesByTwo {
    public static int findFinalValue(int[] nums, int original) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == original) {
                original *= 2;
                i = -1;
            }
        }

        return original;
    }

    public static void main(String[] args) {
        System.out.println(findFinalValue(new int[]{8, 19, 4, 2, 15, 3}, 2));
    }
}
