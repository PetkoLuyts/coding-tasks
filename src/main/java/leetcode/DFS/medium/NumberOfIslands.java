package leetcode.DFS.medium;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int numberOfIslands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    numberOfIslands++;
                    callDFS(grid, row, col);
                }
            }
        }

        return numberOfIslands;
    }

    private static void callDFS(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        callDFS(grid, row + 1, col); // up
        callDFS(grid, row - 1, col); // down
        callDFS(grid, row, col - 1); // left
        callDFS(grid, row, col + 1); // right
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]
                {
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                };

        System.out.println(numIslands(grid));
    }
}