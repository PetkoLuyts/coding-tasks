package leetcode.strings.easy;

public class RemoveTrailingZerosFromString {
    public static String removeTrailingZeros(String num) {
        int i = num.length() - 1;

        while (i >= 0 && num.charAt(i) == '0') i--;

        return num.substring(0, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(removeTrailingZeros("51230100"));
    }
}
