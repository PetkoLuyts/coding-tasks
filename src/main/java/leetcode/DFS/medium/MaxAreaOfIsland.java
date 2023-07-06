package leetcode.DFS.medium;

public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    int area = callDFS(grid, row, col);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private static int callDFS(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;
        int area = 1;

        area += callDFS(grid, row + 1, col); // up
        area += callDFS(grid, row - 1, col); // down
        area += callDFS(grid, row, col - 1); // left
        area += callDFS(grid, row, col + 1); // right

        return area;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]
                {
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
                };

        System.out.println(maxAreaOfIsland(grid));
    }
}
