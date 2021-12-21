package com.coding.patterns.dynamicprogramming.memoize;

public class LongestIncreasingPath {
    private static int dfs(int r, int c, int row, int col, int[][] matrix, int[][] t, int prevVal) {
        if (r < 0 || r >= row || c < 0 || c >= col || matrix[r][c] <= prevVal) {
            return 0;
        }
        if (t[r][c] != 0) {
            return t[r][c];
        }
        int result = 1;
        result = Math.max(result, 1 + dfs(r + 1, c, row, col, matrix, t, matrix[r][c]));
        result = Math.max(result, 1 + dfs(r - 1, c, row, col, matrix, t, matrix[r][c]));
        result = Math.max(result, 1 + dfs(r, c + 1, row, col, matrix, t, matrix[r][c]));
        result = Math.max(result, 1 + dfs(r, c - 1, row, col, matrix, t, matrix[r][c]));
        t[r][c] = result;
        return result;
    }
    public static int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] t= new int[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                dfs(r, c, row, col, matrix, t, -1);
            }
        }
        int max = t[0][0];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                max = Math.max(max, t[r][c]);
            }
        }
        return max;
    }
}
