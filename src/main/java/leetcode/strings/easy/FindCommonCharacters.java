package leetcode.strings.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
    public static List<String> commonChars(String[] words) {
        List<String> commonChars = new ArrayList<>();
        int[] minFrequencies = new int[26];
        Arrays.fill(minFrequencies, Integer.MAX_VALUE);

        for (String word : words) {
            int[] separateFrequency = new int[26];

            for (char ch : word.toCharArray()) {
                separateFrequency[ch - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                minFrequencies[i] = Math.min(separateFrequency[i], minFrequencies[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (minFrequencies[i] > 0) {
                commonChars.add("" + (char)(i + 'a'));
                minFrequencies[i]--;
            }
        }

        return commonChars;
    }

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));
    }
}
