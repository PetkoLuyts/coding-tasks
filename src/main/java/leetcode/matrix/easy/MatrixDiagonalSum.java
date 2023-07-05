package leetcode.matrix.easy;

public class MatrixDiagonalSum {
    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[n - 1 - i][i];
        }

        return n % 2 == 0 ? sum : sum - mat[n / 2][n / 2];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1}
                };

        System.out.println(diagonalSum(matrix));
    }
}
