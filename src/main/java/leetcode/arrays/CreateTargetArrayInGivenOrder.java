package leetcode.arrays;

import java.util.Arrays;

public class CreateTargetArrayInGivenOrder {
    public static int[] createTargetArray(int[] nums, int[] index) {
        Integer[] targetArray = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int indexToPutNumberAt = index[i];

            if (targetArray[indexToPutNumberAt] == null) {
                targetArray[indexToPutNumberAt] = nums[i];
            } else {
                for (int j = i; j > indexToPutNumberAt; j--) {
                    targetArray[j] = targetArray[j - 1];
                }
                targetArray[indexToPutNumberAt] = nums[i];
            }
        }

        return Arrays.stream(targetArray).mapToInt(num -> num).toArray();

//        Second solution
//        ArrayList<Integer> a = new ArrayList<Integer>();
//        for(int i=0;i<nums.length;i++)
//        {
//            a.add(index[i],nums[i]);
//        }
//        int target[] = new int[nums.length];
//        for(int i=0;i<nums.length;i++)
//        {
//            target[i] = a.get(i);
//        }
//        return target;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4};
        int[] index = new int[]{0, 1, 2, 2, 1};

        int[] targetArray = createTargetArray(nums, index);

        System.out.println(Arrays.toString(targetArray));
    }
}
