package com.coding.patterns.graphs;

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
        int max = 0;

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 1)
                    max = Math.max(max, getSize(grid, i, j));

        return max;
    }

    static int getSize(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[i].length || grid[i][j] == 0)
            return 0;

        // Set the current position as visited
        grid[i][j] = 0;

        return 1 +
                getSize(grid, i + 1, j) + getSize(grid, i - 1, j) +
                getSize(grid, i, j + 1) + getSize(grid, i, j - 1);
    }
}
