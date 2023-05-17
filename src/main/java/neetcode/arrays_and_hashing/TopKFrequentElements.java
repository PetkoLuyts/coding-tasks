package neetcode.arrays_and_hashing;

import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);

            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
