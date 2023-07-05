package leetcode.arrays.easy;

public class SumMultiples {
    public static int sumOfMultiples(int n) {
        int result = 0;

        for (int i = 0; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                result += i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(sumOfMultiples(7));
    }
}
