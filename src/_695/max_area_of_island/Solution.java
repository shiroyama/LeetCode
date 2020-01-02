package _695.max_area_of_island;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        int areaOfIsland = new Solution().maxAreaOfIsland(grid);
        System.out.println(areaOfIsland);
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int tmp = dfs(grid, row, col, i, j);
                    max = Math.max(max, tmp);
                }
            }
        }
        return max;
    }

    int dfs(int[][] grid, int row, int col, int r, int c) {
        grid[r][c] = -1;

        int count = 1;
        if (c - 1 >= 0 && grid[r][c - 1] == 1) {
            count += dfs(grid, row, col, r, c - 1);
        }
        if (c + 1 < col && grid[r][c + 1] == 1) {
            count += dfs(grid, row, col, r, c + 1);
        }
        if (r - 1 >= 0 && grid[r - 1][c] == 1) {
            count += dfs(grid, row, col, r - 1, c);
        }
        if (r + 1 < row && grid[r + 1][c] == 1) {
            count += dfs(grid, row, col, r + 1, c);
        }

        return count;
    }
}
