package leetcode.arrays;

public class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;

        for (int row = 0; row < accounts.length; row++) {
            int currentSum = 0;

            for (int col = 0; col < accounts[row].length; col++) {
                currentSum += accounts[row][col];
            }

            if (currentSum > max) max = currentSum;
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] accounts = new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};

        int result = maximumWealth(accounts);

        System.out.println(result);
    }
}
