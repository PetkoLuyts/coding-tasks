package leetcode.hashtable.easy;

import java.util.HashMap;

public class CheckIfNumberHasEqualDigitCountAndDigitValue {
    public static boolean digitCount(String num) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < num.length(); i++) {
            int numberParsed = Character.getNumericValue(num.charAt(i));

            count.put(numberParsed, count.getOrDefault(numberParsed, 0) + 1);
        }

        for (int i = 0; i < num.length(); i++) {
            if (!count.containsKey(i) && Character.getNumericValue(num.charAt(i)) != 0) {
                return false;
            } else if  (count.containsKey(i) && count.get(i) != Character.getNumericValue(num.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String num = "42101000";

        System.out.println(digitCount(num));
    }
}
