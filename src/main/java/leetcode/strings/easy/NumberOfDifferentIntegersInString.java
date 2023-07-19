package leetcode.strings.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberOfDifferentIntegersInString {
    public static int numDifferentIntegers(String word) {
        Set<String> result = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) - '0' > 10) {
                word = word.replace(word.charAt(i), ' ');
            }
        }

        word = word.trim();

        if (!word.equals("")) {
            String[] chunks = word.split("\\s+");

            for (String chunk : chunks) {
                String str = chunk.replaceFirst("^0+", "");

                result.add(str);
            }
        }

        return result.size();

//        return Arrays.stream(word.replaceAll("[a-z]+", " ").split(" "))
//                .filter(s -> !"".equals(s))
//                .map(s -> s.replaceFirst("^0+", ""))
//                .collect(Collectors.toSet())
//                .size();
    }

    public static void main(String[] args) {
        System.out.println(numDifferentIntegers("a123bc34d8ef34"));
    }
}
