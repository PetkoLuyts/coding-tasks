package leetcode.hashtable.easy;

import java.util.HashSet;

public class HappyNumber {
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1) {
            int result = 0;

            while (n != 0) {
                result += Math.pow(n % 10, 2);
                n /= 10;
            }

            if (set.contains(result)) {
                return false;
            }

            set.add(result);
            n = result;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
