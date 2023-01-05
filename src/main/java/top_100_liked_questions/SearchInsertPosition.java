package top_100_liked_questions;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int midPoint = left + (right - left) / 2;

            if (target == nums[midPoint]) {
                return midPoint;
            } else if (target < nums[midPoint]) {
                right = midPoint - 1;
            } else if (target > nums[midPoint]) {
                left = midPoint + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 5, 6};
        int target = 2;

        System.out.println(searchInsert(nums, target));
    }
}
