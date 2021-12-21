package com.algoexpert;


import java.util.ArrayList;
import java.util.List;

/**
 * AlgoExpert: https://www.algoexpert.io/questions/River%20Sizes
 */
public class RiverSize {
    public static int size;
    private static int dfs(int r, int c, int rows, int cols, int[][] matrix) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || matrix[r][c] == 0) {
            return 0;
        }
        matrix[r][c] = 0;
        size++;
        dfs(r + 1, c, rows, cols, matrix);
        dfs(r - 1, c, rows, cols, matrix);
        dfs(r, c + 1, rows, cols, matrix);
        dfs(r, c - 1, rows, cols, matrix);
        return size;
    }
    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(matrix[r][c] == 1) {
                    size = 0;
                    dfs(r, c, rows, cols, matrix);
                    if (size != 0) {
                        result.add(size);
                    }
                }
            }
        }
        return result;
    }
}
