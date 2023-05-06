package leetcode.hashtable.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TwoOutOfThree {
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> common = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int num : nums1) set1.add(num);

        for (int num : nums2) {
            if (set1.contains(num)) {
                common.add(num);
            } else {
                set2.add(num);
            }
        }

        for (int num : nums3) {
            if (set1.contains(num) || set2.contains(num)) {
                common.add(num);
            }
        }

        return new ArrayList<>(common);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 3, 2};
        int[] nums2 = new int[]{2, 3};
        int[] nums3 = new int[]{3};

        List<Integer> output = twoOutOfThree(nums1, nums2, nums3);

        System.out.println(output);
    }
}
