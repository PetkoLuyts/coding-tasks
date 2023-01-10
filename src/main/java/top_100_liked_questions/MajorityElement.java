package top_100_liked_questions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int occurrences = map.get(nums[i]);
                occurrences++;
                map.put(nums[i], occurrences);
            }
        }

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 2, 1, 1, 1, 2, 2, 5, 5, 5, 5, 5};

        System.out.println(majorityElement(nums));
    }
}
