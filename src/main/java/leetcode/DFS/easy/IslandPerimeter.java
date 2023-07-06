package leetcode.DFS.easy;

public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                   perimeter += callDFS(grid, row, col);
                }
            }
        }

        return perimeter;
    }

    private static int callDFS(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 1;
        }

        if (grid[row][col] == 0) {
            return 1;
        }

        if (grid[row][col] == -1) {
            return 0;
        }

        int count = 0;
        grid[row][col] = -1;

        count += callDFS(grid, row-1, col);
        count += callDFS(grid, row, col-1);
        count += callDFS(grid, row, col+1);
        count += callDFS(grid, row+1, col);

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]
                {
                        {0, 1, 0, 0},
                        {1, 1, 1, 0},
                        {0, 1, 0, 0},
                        {1, 1, 0, 0}
                };

        System.out.println(islandPerimeter(grid));
    }
}
