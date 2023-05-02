package leetcode.blankfactor.arrays;

import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Input count of rows: ");
        int rows = Integer.parseInt(scanner.nextLine());
        System.out.printf("Input count of cols: ");
        int cols = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col <matrix[row].length; col++) {
                System.out.printf("Input number for [%d][%d]: ", row, col);
                int inputNumber = Integer.parseInt(scanner.nextLine());
                matrix[row][col] = inputNumber;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col <matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }

        System.out.println(sum);
    }
}