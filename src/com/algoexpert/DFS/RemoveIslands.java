package com.algoexpert.DFS;

/**
 * AlgoExpert: https://www.algoexpert.io/questions/Remove%20Islands
 */
public class RemoveIslands {
    private static void dfs(int r, int c, int[][] matrix, int row, int col) {
        if (r < 0 || r >= row || c < 0 || c >= col || matrix[r][c] != 1) {
            return;
        }
        matrix[r][c] = 2;
        dfs(r - 1, c, matrix, row, col);
        dfs(r + 1, c, matrix, row, col);
        dfs(r, c - 1, matrix, row, col);
        dfs(r, c + 1, matrix, row, col);
    }

    /*
	   Time Complexity : O (N * M)
	   Space Complexity: O (N * M) because of DFS Recursive call stack
	*/
    public static int[][] removeIslands(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // Perform DFS on 1st row, 1st column, last row & last column
        // 1st column
        for (int r = 0; r < row; r++) {
            dfs(r, 0, matrix, row, col);
        }
        // 1st row
        for (int c = 0; c < col; c++) {
            dfs(0, c, matrix, row, col);
        }
        // last column
        for (int r = 0; r < row; r++) {
            dfs(r, col - 1, matrix, row, col);
        }
        // last row
        for (int c = 0; c < col; c++) {
            dfs(row - 1, c, matrix, row, col);
        }

        // iterate over matrix, replace all 2 with 1 and all 1 with 0
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (matrix[r][c] == 1) {
                    matrix[r][c] = 0;
                }
                if (matrix[r][c] == 2) {
                    matrix[r][c] = 1;
                }
            }
        }
        return matrix;
    }
}
