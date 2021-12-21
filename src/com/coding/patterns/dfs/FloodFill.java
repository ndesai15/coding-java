package com.coding.patterns.dfs;


/**
 * LeetCode Problem: https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {
    private static void dfs(int r, int c, int row, int col, int[][] image, int newColor, int startColor) {
        if (r >= row || r < 0 || c >= col || c < 0 || image[r][c] != startColor ||
        image[r][c] == newColor) return;

        image[r][c] = newColor;
        // Apply dfs
        dfs(r + 1, c, row, col, image, newColor, startColor);
        dfs(r - 1, c, row, col, image, newColor, startColor);
        dfs(r, c + 1, row, col, image, newColor, startColor);
        dfs(r, c - 1, row, col, image, newColor, startColor);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Graph problem as a Grid
        int row = image.length;
        int col = image[0].length;

        // start dfs at (sr,sc) coordinate
        dfs(sr, sc, row, col, image, newColor, image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {
        int[][] a= {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        System.out.println(floodFill(a, 1, 1, 2));
    }
}
