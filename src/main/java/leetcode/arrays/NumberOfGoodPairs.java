package leetcode.arrays;

public class NumberOfGoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1, 1, 3};

        int result = numIdenticalPairs(nums);

        System.out.println(result);
    }
}
