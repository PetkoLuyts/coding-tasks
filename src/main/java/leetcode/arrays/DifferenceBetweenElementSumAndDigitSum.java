package leetcode.arrays;

public class DifferenceBetweenElementSumAndDigitSum {
    public static int differenceOfSum(int[] nums) {
        int index = 0;
        int sum = 0, digitSum = 0;
        boolean isProcessed = false;

        while (index < nums.length && nums[index] > 0) {
            int currentNum = nums[index];

            if (!isProcessed) {
                sum += currentNum;
                isProcessed = true;
            }

            int digit = currentNum % 10;
            digitSum += digit;

            if(nums[index] / 10 <= 0) {
                isProcessed = false;
                index++;
            } else nums[index] /= 10;
        }

        return Math.abs(sum - digitSum);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};

        int result = differenceOfSum(nums);

        System.out.println(result);
    }
}
