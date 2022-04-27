package com.coding.patterns.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem: https://leetcode.com/problems/shift-2d-grid/
 */

// Time Complexity: O(M * N), M # of rows & N # of cols
// Space Complexity: O(M * N), M # of rows & N # of cols
public class Shift2DGrid {

    private static int coOrdsToIdx(int r, int c, int cols) {
        return r * cols + c;
    }

    private static int[] idxToCoOrds(int idx, int cols) {
        return new int[]{idx / cols, idx % cols};
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        int[][] newGrid = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int idx = (coOrdsToIdx(r, c, cols) + k) % (rows * cols);
                int[] newCoOrds = idxToCoOrds(idx, cols) ;
                newGrid[newCoOrds[0]][newCoOrds[1]] = grid[r][c];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int[] row: newGrid) {
            List<Integer> temp = new ArrayList<>();
            for (int r: row) temp.add(r);
            result.add(temp);
        }

        return result;
    }
}
