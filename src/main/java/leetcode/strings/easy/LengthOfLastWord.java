package leetcode.strings.easy;

import java.util.Arrays;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String[] splitted = s.trim().split("\\s+");

        return splitted[splitted.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Today is a nice day"));
    }
}
