package leetcode.strings.easy;

import java.util.Arrays;

public class SortingTheSentence {
    public static String sortSentence(String s) {
        String[] splitted = s.split(" ");
        String[] result = new String[splitted.length];

        for (int i = 0; i < splitted.length; i++) {
            String str = splitted[i];
            int pos = Integer.parseInt(str.substring(str.length() - 1));
            String text = str.substring(0, str.length() - 1);
            result[pos - 1] = text;
        }

        return String.join(" ", result).trim();
    }

    public static void main(String[] args) {
        String s = "Myself2 Me1 I4 and3";

        System.out.println(sortSentence(s));
    }
}
