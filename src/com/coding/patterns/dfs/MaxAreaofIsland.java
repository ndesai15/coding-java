package com.coding.patterns.dfs;

/**
 * LeetCode Problem: https://leetcode.com/problems/max-area-of-island/
 */

// Time Complexity: O(M*N)

public class MaxAreaofIsland {

    public static void main(String[] args) {
        // Example Testcases

        // Output 6
        System.out.println(maxAreaOfIsland(new int[][] {
                { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
        }));

        // Output 0
        System.out.println(maxAreaOfIsland(new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 } }));
    }

    static public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, res = 0;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == 1)
                    res = Math.max(res, dfs(grid, rows, cols, i, j));

        return res;
    }

    static int dfs(int[][] grid, int rows, int cols, int i, int j) {
        if (i < 0 || j < 0 || i == rows || j == cols || grid[i][j] == 0)
            return 0;

        // Set the current position as visited
        grid[i][j] = 0;

        return 1 +
                dfs(grid, rows, cols, i + 1, j) + dfs(grid, rows, cols, i - 1, j) +
                dfs(grid, rows, cols, i, j + 1) + dfs(grid, rows, cols, i, j - 1);
    }
}
