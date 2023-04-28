package leetcode.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {


            List<String> groupOfAnagrams = new ArrayList<>();

            for (int j = i + 1; j < strs.length; j++) {
                char[] firstWordArray = strs[i].toCharArray();
                char[] secondWordArray = strs[j].toCharArray();

                Arrays.sort(firstWordArray);
                Arrays.sort(secondWordArray);

                String firstWord = String.valueOf(firstWordArray);
                String secondWord = String.valueOf(secondWordArray);

                if (firstWord.equals(secondWord)) {
                    groupOfAnagrams.add(strs[j]);
                }
            }

            groupOfAnagrams.add(strs[i]);
            anagrams.add(groupOfAnagrams);
        }

        return anagrams;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};

        List<List<String>> anagrams = groupAnagrams(strs);

        for (List<String> group : anagrams) {
            System.out.println(Arrays.toString(group.toArray()));
        }
    }
}
